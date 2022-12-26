(* Exame Métodos Formais 
   Nome:  Victor Eduardo Requia*)

(* Todas as declarações devem ser feitas nesse arquivo,
   não deve ser importado nenhum módulo adicional. *)

Require Import Arith.
Require Import Coq.Lists.List.
Import ListNotations.


Fixpoint index {X : Set} (n : nat) (l : list X) : option X :=
  match l with
  | [] => None
  | h :: t => if n =? 0 then Some h else index (pred n) t
  end. 


(* Questão 1 *)

Theorem repeat_n : forall {X:Set} (n:nat) (x:X),
  length (repeat x n) = n.
Proof. 
  intros. 
  induction n.
  - auto.
  - simpl. 
    rewrite IHn.
    reflexivity.
Qed.

(* Questão 2 *)


(* Alguns Teoremas uteis envolvendo <=
Theorem le_pred : forall n m, n <= m -> pred n <= pred m.
Theorem le_S_n  : forall n m, S n <= S m -> n <= m.
Theorem le_0_n  : forall n, 0 <= n.
Theorem le_n_S  : forall n m, n <= m -> S n <= S m. *)

Theorem le_plus_l : forall a b,
  a <= a + b.
Proof.
  intros.
  induction a as [| a' IH].
  - apply le_0_n.
  - simpl.
    apply le_n_S.
    apply IH.
Qed.


(* Questão 3*)


Theorem repeat_index : forall {X:Set} (x:X) (i:nat) (n:nat) ,
  i <= n -> index i (repeat x (S n)) = Some x.
Proof.
  intros. 
  induction n.
  - induction i.
    + auto.
    + inversion H.
  - induction i.
    + auto.
    + auto.
Admitted.
  
(* Questão 4 *) 

Theorem index_map : forall {X Y:Set} (n:nat) (f:X->Y) (l:list X) (x:X), 
  index n l = Some x -> Some (f x) = index n (map f l).
Proof.
  intros X Y n f. 
  induction n as [| n' IH].
  - intros l x H1. 
    destruct l as [| h t].
    + discriminate H1.
    + simpl in H1.
      injection H1 as H1'.
      simpl.
      rewrite H1'.
      reflexivity.
  - intros.
    induction l.
    + simpl. 
      discriminate.
    + simpl.
      simpl in H.
      apply IH.
      apply H.
Qed.
    