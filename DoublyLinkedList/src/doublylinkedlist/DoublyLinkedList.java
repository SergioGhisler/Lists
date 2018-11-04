/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

/**
 *
 * @author sergio
 */
public class DoublyLinkedList {

    /**
     * @param args the command line arguments
     * @return
     */
    private int size = 0;
    private Nodo head;
    private Nodo tail;

    public boolean empty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public boolean insert(int pos, Object obj) {
        if (pos==0){
            pushHead(obj);
            return true;
        }
        else if(pos==size-1){
            pushTail(obj);
            return true;
        }else if (pos<size-1 && pos>0) {
        	Nodo temp = head;
        for(int i = 0; i<pos-1;i++) 
        	temp = temp.getNextElement();
        
        temp.setNextElement(new Nodo(obj,temp.getNextElement(),temp));
        	size++;
        	return true;
        }
        	return false;
    }

    public void pushHead(Object obj) {
        Nodo nodo = new Nodo(obj);
        if (empty() == true) {
            tail = nodo;
            head = nodo;
            size++;
        } else {
            nodo.setNextElement(head);
            head.setPreviousElement(nodo);
            head = nodo;
            size++;
        }
    }

    public void pushTail(Object obj) {
        Nodo nodo = new Nodo(obj);
        if (empty() == true) {
            tail = nodo;
            head = nodo;
            size++;
        } else {
            nodo.setPreviousElement(tail);
            tail.setNextElement(nodo);
            tail = nodo;
            size++;
        }
    }

    public Object popHead() {
        if(empty() == true){
            return null;
        }
        Nodo cabeza = head;
        head = cabeza.getNextElement();
        head.setPreviousElement(null);
        size--;
        return cabeza.getValue();
    }

    public Object popTail() {
      if (empty()) {
          return null;
      }     
      Nodo reserva = new Nodo(tail.getValue());
      tail = tail.getPreviousElement();
      tail.setNextElement(null);
      size--;
      return reserva.getValue();
    }

    public Object peekHead() {
        return head.getValue();
    }

    public Object peekTail() {
            return tail.getValue();
    }

    public boolean remove(int pos) {
        if (pos==0){
            popHead();
            return true;
        }
        else if(pos==size-1){
            popTail();
            return true;
        }else if (pos<size-1 && pos>0) {
        	Nodo temp = head;
        for(int i = 0; i<pos-1;i++) 
        	temp = temp.getNextElement();
        
        temp.setNextElement(temp.getNextElement().getNextElement());
        
        temp.getNextElement().setPreviousElement(temp);
        	size--;
        	return true;
        }
        	return false;
    }

    public void remove(UsuariosBanco obj) {
    	Nodo temp = head;
    for (int i = 0; i<size;i++) {
    	temp.getValue().getDni()
    	temp = temp.getNextElement()
    }
    }

    public static void main(String[] args) {
        DoublyLinkedList lista = new DoublyLinkedList();
        System.out.println(lista.empty());
        UsuariosBanco p1 = new UsuariosBanco("Sergio", 20,"1234",123);
        UsuariosBanco p2 = new UsuariosBanco("Fran", 23,"1234",12544);
        UsuariosBanco p3 = new UsuariosBanco("Marina", 14,"12457563",235235);
        UsuariosBanco p4 = new UsuariosBanco ("Yoshi",34,"34234",24353);
        
        lista.pushHead(p1);
        lista.pushHead(p2);
        lista.pushHead(p3);
        lista.insert(1, p4);
        System.out.println(lista.popHead());
        System.out.println(lista.peekHead()); 
        System.out.println(lista.peekTail());
        System.out.println(lista.size());
        System.out.println(lista.remove(1));
        System.out.println(lista.peekTail());
        System.out.println(lista.popTail());
       System.out.println(lista.peekTail());
       System.out.println(lista.size());
      System.out.println(p1.compareTo(p2));
        lista.sort(UsuariosBanco);
    }

}