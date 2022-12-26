(* Primeira Prova de Métodos Formais 
   Nome: Victor Eduardo Requia                                       *)

(* Todas as declarações devem ser feitas nesse arquivo,
   não deve ser importado nenhum módulo adicional. *)

Require Import Coq.Lists.List.
Require Import Coq.Bool.Bool.
Import ListNotations.



Fixpoint evenb (n:nat) : bool :=
  match n with
  | O        => true
  | S O      => false
  | S (S n') => evenb n'
  end.

(* Questão 1: Prove que para qualquer natural n, n * 2 é par *)
Theorem evenb_2 : forall n:nat,
  evenb (n * 2) = true.
Proof. 
  intro n.
  simpl.
  induction n as [|n' IH].
  - reflexivity.
  -  simpl. apply IH.
Qed.

(* Questão 2: *) 

Theorem true_or : forall (b1 b2:bool), b1 = true -> b2 = true -> b1 && b2 = true.
Proof.
  intros b1 b2.
  - simpl. 
    intros.
    rewrite H.
    rewrite H0.
    simpl.
    reflexivity.
Qed.

(* Questão 3 - Prove que a função fold_map é equivalente à função map (fold_map_correct). *)

Fixpoint map {X Y: Type} (f:X->Y) (l:list X) : (list Y) :=
  match l with
  | []     => []
  | h :: t => (f h) :: (map f t)
  end.

Fixpoint fold {X Y: Type} (f: X->Y->Y) (l: list X) (b: Y) : Y :=
  match l with
  | nil => b
  | h :: t => f h (fold f t b)
  end.

Definition fold_map {X Y: Type} (f: X -> Y) (l: list X) : list Y :=
  fold (fun x l' => f x :: l') l [].
  
Theorem fold_map_correct : forall (X Y: Type) (f: X -> Y) (l: list X),
  map f l = fold_map f l.
Proof.
  intros.
  induction l as [| h t IH].
  - reflexivity.
  - simpl.
    rewrite -> IH.
    unfold fold_map.
    simpl. reflexivity.
Qed.


(* Questão 4 - Prove o teorema involutive_f_map *)

Definition compose {A B C} (g : B -> C) (f : A -> B) :=
  fun x : A => g (f x).

Notation "g (.) f" := (compose g f)
                     (at level 5, left associativity).
Definition involutive {A : Type} (f : A -> A) :=
  forall x: A, f (f x) = x.

Theorem involutive_f_map : forall (A : Type) (f : A -> A) (l:list A), 
  involutive f -> map f (.) f l = l.
Proof.
    intros A l l0.
    intros.
    simpl.
    induction l0 as [| h t IH].
  - simpl. 
    reflexivity.
  - simpl.  
    rewrite IH. 
    simpl.
Admitted.


Theorem involutive_f_map : forall (A : Type) (f : A -> A) (l:list A), 
  involutive f -> map f (.) f l = l.
Proof.
    intros A l l0.
    intros.
  + simpl.
    induction l0 as [| h t IH].
  - simpl. 
    reflexivity.
  - simpl.  
    rewrite IH. 
    simpl.
Admitted.
