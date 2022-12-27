(* Victor Eduardo Requia 15/12/2022
 Exercícios - Expressões Regulares *)

Require Export Coq.Init.Logic.
Require Export Coq.Bool.Bool.
Require Export Coq.Lists.List.
Import ListNotations.

Inductive reg_exp {T : Type} : Type :=
  | EmptySet
  | EmptyStr
  | Char (t : T)
  | App (r1 r2 : reg_exp)
  | Union (r1 r2 : reg_exp)
  | Star (r : reg_exp).

Inductive exp_match {T} : list T -> reg_exp -> Prop :=
  | MEmpty : exp_match [] EmptyStr
  | MChar x : exp_match [x] (Char x)
  | MApp s1 re1 s2 re2
             (H1 : exp_match s1 re1)
             (H2 : exp_match s2 re2) :
             exp_match (s1 ++ s2) (App re1 re2)
  | MUnionL s1 re1 re2
                (H1 : exp_match s1 re1) :
                exp_match s1 (Union re1 re2)
  | MUnionR re1 s2 re2
                (H2 : exp_match s2 re2) :
                exp_match s2 (Union re1 re2)
  | MStar0 re : exp_match [] (Star re)
  | MStarApp s1 s2 re
                 (H1 : exp_match s1 re)
                 (H2 : exp_match s2 (Star re)) :
                 exp_match (s1 ++ s2) (Star re).

Notation "s =~ re" := (exp_match s re) (at level 80).

Fixpoint reg_exp_of_list {T} (l : list T) :=
  match l with
  | [] => EmptyStr
  | x :: l' => App (Char x) (reg_exp_of_list l')
  end.


(* Exercício 1*)
(* Dica pode ser necessário o uso da tática [generalize dependent]. *)

Lemma reg_exp_of_list_spec : forall T (s1 s2 : list T),
  s1 =~ reg_exp_of_list s2 <-> s1 = s2.
Proof.
  intros.
  split.
  - intros.
    generalize dependent s1.
    induction s2.
    + intros. inversion H. reflexivity.
    + intros. simpl in H.
      inversion H.
      apply IHs2 in H4.
      inversion H3.
      rewrite -> H4.
      reflexivity.
  - intros.
    generalize dependent s1.
    induction s2.
    + intros. simpl. rewrite -> H. apply MEmpty.
    + intros. simpl.
      rewrite -> H.
      apply (MApp [a] _ s2).
      * apply MChar.
      * apply IHs2. reflexivity.
Qed.

Fixpoint re_not_empty {T : Type} (re : @reg_exp T) : bool :=
  match re with
    | EmptySet => false
    | EmptyStr => true
    | Char _ => true
    | App re1 re2 => andb (re_not_empty re1) (re_not_empty re2)
    | Union re1 re2 => orb (re_not_empty re1) (re_not_empty re2)
    | Star re1 => true
end.

(* Exercício 2*)
Lemma re_not_empty_correct : forall T (re : @reg_exp T),
  (exists s, s =~ re) <-> re_not_empty re = true.
Proof.
  intros. split.
  - intros. destruct H. induction H.
    + simpl. reflexivity.
    + simpl. reflexivity.
    + simpl. rewrite IHexp_match1. rewrite IHexp_match2. reflexivity.
    + simpl. rewrite IHexp_match. reflexivity.
    + simpl. rewrite IHexp_match. apply orb_true_iff. right. reflexivity.
    + simpl. reflexivity.
    + simpl. reflexivity.
  - intros. induction re.
    + exists []. inversion H.
    + exists []. apply MEmpty.
    + exists [t]. apply MChar.
    + simpl in H. rewrite andb_true_iff in H. destruct H.
      destruct (IHre1 H) as [a H1]. destruct (IHre2 H0) as [b H2].
      exists (a++b). apply MApp. 
        * apply H1.
        * apply H2. 
    + simpl in H. rewrite orb_true_iff in H. destruct H as [H | H].
      * destruct (IHre1 H) as [a X]. exists a. apply MUnionL. apply X.
      * destruct (IHre2 H) as [b X]. exists b. apply MUnionR. apply X.
    + exists []. apply MStar0.
Qed.

(* Exercício 3*)
Lemma MStar'' : forall T (s : list T) (re : reg_exp),
  s =~ Star re ->
  exists ss : list (list T),
    s = fold_right (@app T) [] ss
    /\ forall s', In s' ss -> s' =~ re.
Proof.
  intros T s re H. remember (Star re) as re' eqn:eqre.
  induction H as [|x'
                  |s1 re1 s2 re2 Hr1 IH1 Hr2 IH2
                  |s1 re1 re2 Hr IH
                  |re1 s2 re2 Hr IH
                  |re1
                  |s1 s2 re1 Hr1 IH1 Hr2 IH2].
  - inversion eqre.
  - inversion eqre.
  - inversion eqre.
  - inversion eqre.
  - inversion eqre.
  - exists []. split.
    + reflexivity. 
    + intros s' H. inversion H.
  - destruct (IH2 eqre) as [ss' [L R]].
    exists (s1::ss'). split.
    + simpl. rewrite <- L. reflexivity.
    + intros s' H. destruct H.
      * rewrite <- H. inversion eqre. rewrite H1 in Hr1. apply Hr1.
      * apply R. apply H.
Qed.
