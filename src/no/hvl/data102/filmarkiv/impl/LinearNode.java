package no.hvl.data102.filmarkiv.impl;



public class LinearNode<T> {
	
    private T data;
    private LinearNode<T> neste;

    public LinearNode(T elem) {
        this.data = elem;
        this.neste = null;
    }

    public T getElement() {
        return data;
    }

    public void setElement(T element) {
        this.data = element;
    }

    public LinearNode<T> getNeste() {
        return neste;
    }

    public void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }
}
