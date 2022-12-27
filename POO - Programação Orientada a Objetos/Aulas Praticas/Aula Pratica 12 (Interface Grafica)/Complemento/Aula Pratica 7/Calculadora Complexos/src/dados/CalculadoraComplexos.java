package dados;

public class CalculadoraComplexos implements IOperacoesBasicas<Complexo>{
    @Override
    public Complexo soma(Complexo operador1, Complexo operador2){
        int real = operador1.getReal() + operador2.getReal();
        int imaginario = operador1.getImaginario() + operador2.getImaginario();
        return new Complexo(real, imaginario);
    }
    
    @Override
    public Complexo subtracao(Complexo operador1, Complexo operador2){
        int real = operador1.getReal() - operador2.getReal();
        int imaginario = operador1.getImaginario() - operador2.getImaginario();
        return new Complexo(real, imaginario);
    }
}
