(* Primeira Prova de Segunda chamada de Métodos Formais 
   Nome:                                       *)

(* Todas as declarações devem ser feitas nesse arquivo,
   não deve ser importado nenhum módulo. *)

Require Import Coq.Lists.List.
Import ListNotations.

(* Questão 1 *)

Fixpoint evenb (n:nat) : bool :=
  match n with
  | O        => true
  | S O      => false
  | S (S n') => evenb n'
  end.

Theorem evenb_2 : forall n:nat,
  evenb (2 * n) = true.
Proof. 
  Admitted.

(* Questão 2 *)

Definition oddb (n:nat) : bool   :=   negb (evenb n).

Theorem even_S_odd : forall n, 
  evenb n = oddb (S n).
Proof.
  Admitted.

(* Questão 3 *)

Theorem rev_app_distr: forall X (l1 l2 : list X),
  rev (l1 ++ l2) = rev l2 ++ rev l1.
Proof.
  Admitted.

(* Questão 4 *)

Fixpoint fold {X Y: Type} (f: X->Y->Y) (l: list X) (b: Y) : Y :=
  match l with
  | nil => b
  | h :: t => f h (fold f t b)
  end.

Theorem app_comm_fold :forall {X Y} (f: X->Y->Y) l1 l2 b,
  fold f (l1 ++ l2) b = fold f l1 (fold f l2 b).
Proof.
  Admitted.

