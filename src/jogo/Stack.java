package jogo;

import jogo.estrutura;

public class Stack<T> extends estrutura<T>{

	public Stack(){
		super();
	}
	
	public Stack(int capacidade){
		super(capacidade);
	}
	
	public void empilha(T elemento){
		//this.elementos[this.tamanho] = elemento;
		//this.tamanho++;
		
		//this.elementos[this.tamanho++] = elemento;
		if(this.tamanho == 0) {
			this.adiciona(elemento);
		}else {
			this.adiciona(this.tamanho, elemento);
		}
	}
	
	public T espiar(){
		
		if (this.estaVazia()){
			return null;
		}
		
		return (T) this.elementos[this.tamanho - 1];
	}
	
	public T get(Integer n) {
		int x = tamanho();
		for(int i = 0;i <= x;i++) {
			if(this.elementos[i] == elementos[n]) {
				return this.elementos[i];
			}
		}
		return null;
	}
	
	public int size() {
		int x = tamanho();
		return x;
	}
	
	public T desempilha(){
		
		final int POS = this.tamanho - 1;
		
		if (this.estaVazia()){
			return null;
		}
		
		T elementoASerRemovido = this.elementos[POS];
		
		this.remove(POS);
		
		return elementoASerRemovido;
		
	}
}