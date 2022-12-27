(*
Victor Eduardo Requia 
Lista 1
26/09/2022
*)

(*Biblioteca*)
Require Import Coq.Arith.PeanoNat.
(**)

(*Funções auxiliares*)
Fixpoint sum (n : nat) : nat :=
match n with
| O => O
| S n' => n + sum n'
end.

Fixpoint div2 (n:nat) : nat :=
match n with
| O => O
| S O => O
| S (S n') => S (div2 n')
end.
(**)

(*Provas*)
Theorem plus_n_1 : forall (n : nat),
n + 1 = S (n).
Proof. intro n. induction n as [| n' Hipotese].
       - simpl. 
          reflexivity.
       - simpl. 
          rewrite <- Hipotese. 
          reflexivity.
Qed.

Theorem plus_n_Sm : forall (n m: nat),
  n + S m = S (n + m).
Proof. intros n m. 
       induction m as [| m' Hipotese].
       - rewrite Nat.add_0_r.
         rewrite plus_n_1.
         reflexivity.
       - rewrite Hipotese. 
         rewrite Nat.add_comm.
         simpl.
         rewrite Nat.add_comm.
         reflexivity.
Qed.

Theorem mult_2_n_plus : forall (n : nat),
  n + n = 2 * n.
Proof. intros n.
       induction n as [| n' Hipotese].
       - simpl.
         reflexivity.
       - simpl. 
         rewrite Nat.add_0_r.
         reflexivity.
Qed.

Theorem mul2_div2 : forall n : nat,
  n = div2 (2 * n).
Proof. intro n.
       induction n as [| n' Hipotese].
       - simpl.
         reflexivity.
       - rewrite Nat.mul_comm.
         simpl. rewrite Nat.mul_comm. 
         rewrite <- Hipotese.
         reflexivity. 
Qed.

Theorem div2_mult2_plus: forall (n m : nat),
  n + div2 m = div2 (2 * n + m).
Proof. intros n m. induction n as [| n' Hipotese].
        - simpl.
          reflexivity.
        - simpl. 
          rewrite plus_n_Sm.
          rewrite Hipotese.
          simpl. reflexivity.
Qed.

Theorem mult_Sn_m : forall (n m : nat),
  S n * m = m + n * m.
Proof. intros n m. induction n as [| n' Hipotese].
       - simpl. 
        reflexivity.
       - rewrite <- Nat.add_1_l.
         rewrite Nat.mul_add_distr_r. 
         rewrite Nat.mul_1_l. simpl.
         reflexivity.
Qed.

Theorem sum_Sn : forall n : nat,
  sum (S n) = S n + sum n.
Proof. intro. induction n as [| n' Hipotese].
       - simpl.
         reflexivity.
       - simpl.
         reflexivity.
Qed.

Theorem sum_n : forall n : nat,
  sum n = div2 (n * (n + 1)).
Proof. simpl. intro. induction n as [|n' Hipotese].
       - simpl.
         reflexivity.
       - rewrite plus_n_1.
         rewrite Nat.mul_comm.
         rewrite mult_Sn_m.
         rewrite mult_Sn_m.
         simpl.
         rewrite Nat.mul_comm.
         rewrite <- Nat.add_1_l.
         simpl. 
         rewrite plus_n_Sm.
         simpl.
         rewrite Hipotese.
         simpl.
Abort.