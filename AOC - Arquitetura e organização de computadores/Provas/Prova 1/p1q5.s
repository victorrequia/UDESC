	.data 
txt_endl:
	.asciiz "\n"

	.text
	.globl main
main:
	li $v0, 5
	syscall
	move $a0, $v0
	
	li $v0, 5
	syscall
	move $a1, $v0
	
	jal cont
	
end:
	li $v0, 10
	syscall

parada1:
	addi $sp, $sp, -8
	sw $s1, 0($sp)
	sw $ra, 4($sp)
	move $s1, $a0
	
	li $t1,2
	div $a0, $t1
	mflo $a0
	jal cont
	
	add $v0, $a0, $s1
	bne	
	jr $ra
	
	lw $s1, 0($sp)
	lw $ra, 4($sp)
	addi  $sp, $sp, 8
cont:
	li $t0, 1
	ble $a0, $t0, parada
	
	addi $sp, $sp, -8
	sw $s0, 0($sp)
	sw $ra, 4($sp)
	
	li $t1,2
	div $a0, $t1
	mfhi $s0
	
	beqz $s0, parada1
	
	lw $s0, 0($sp)
	lw $ra, 4($sp)
	addi  $sp, $sp, 8

parada:
	li $v0, $a0
	jr $ra