(* Nome: Victor Eduardo Requia *)

Require Export Coq.Init.Logic.
Require Export Coq.Lists.List.
Import ListNotations.


(* Exercício 1*)
Theorem or_distributes_over_and : forall P Q R : Prop,
  P \/ (Q /\ R) <-> (P \/ Q) /\ (P \/ R).
Proof.
  intros.
  split.
  - intros.
    split.
    + destruct H.
      * left. apply H.
      * destruct H.
        right.
        apply H.
    + destruct H.
      * left. apply H.
      * destruct H.
        right.
        apply H0.
  - intros.
    destruct H.
    destruct H.
    + left. apply H.
    + destruct H0.
      * left.
        apply H0.
      * right.
        split.
          apply H.
          apply H0.
Qed.

(* Exercício 2*)

Theorem dist_exists_and : forall (X:Type) (P Q : X -> Prop),
  (exists x, P x /\ Q x) -> (exists x, P x) /\ (exists x, Q x).
Proof.
  intros. destruct H. destruct H. split.
  + exists x. apply H.
  + exists x. apply H0.
Qed.

(* Exercício 3*)

Fixpoint In {A : Type} (x : A) (l : list A) : Prop :=
  match l with
  | [] => False
  | x' :: l' => x' = x \/ In x l'
  end.

Lemma In_map_iff :
  forall (A B : Type) (f : A -> B) (l : list A) (y : B),
    In y (map f l) <->
    exists x, f x = y /\ In x l.
Proof.
  intros A B f l y.
  split.
  - induction l as [|x' l' Hl'].
    + simpl. contradiction.
    + simpl. intros [H | H].
      * exists x'. split. apply H. left. reflexivity.
      * apply Hl' in H. destruct H as [x [H1 H2]]. exists x. split. apply H1. right. apply H2.
  - induction l as [|x' l' Hl'].
    + simpl. intros [x [H1 []]].
    + simpl. intros [x [H1 [H2 | H2]]].
      * left. rewrite -> H2. apply H1.
      * right. assert (H' : exists x: A, f x = y /\ In x l'). exists x. split. apply H1. apply H2.
      apply Hl' in H'. apply H'.
Qed.

(* Exercício 4*)

Lemma In_app_iff : forall A l l' (a:A),
  In a (l++l') <-> In a l \/ In a l'.
Proof.
  intros.
  split.
  - induction l as [| h t IH].
    + simpl. intros. right. apply H.
    + simpl. intros.
      apply or_assoc.
      destruct H.
      * left. apply H.
      * right. apply IH. apply H.
  - induction l as [| h t IH].
    + simpl. intros. destruct H.
        destruct H.
        apply H.
    + simpl. intros. destruct H. destruct H.
        left. apply H.
        right. apply IH. left. apply H.
        right. apply IH. right. apply H.
Qed.

(* Exercício 5*)

Fixpoint All {T : Type} (P : T -> Prop) (l : list T) : Prop :=
  match l with
  | [] => True
  | (h :: t) => P h /\ All P t 
  end.

Lemma All_In :
  forall T (P : T -> Prop) (l : list T),
    (forall x, In x l -> P x) <->
    All P l.
Proof.
  intros.
  induction l. 
  - split.
    + reflexivity. 
    + simpl. intros. destruct H0.
  - simpl. split.
    + split. 
        * apply H. left. reflexivity. 
        * apply IHl. intros. apply H. right. apply H0.
    + intros. destruct H. destruct H0.
        * rewrite <- H0. apply H.
        * rewrite <- IHl in H1. apply H1. apply H0.
Qed.

(* Exercício 6*)

Theorem or_implies : forall (P Q : Prop), ~P \/ Q -> P -> Q.
Proof.
  intros.
  destruct H.
  contradiction.
  apply H.
Qed.
  

(* Exercício 7*)
Theorem implies_or_peirce : forall (P Q : Prop), (~P \/ Q) -> ((P -> Q) -> P) -> P.
Proof.
  intros.
  apply H0.
  destruct H.
  - contradiction.
  - intros. 
    apply H.
Qed.


