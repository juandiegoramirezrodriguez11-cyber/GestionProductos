package gestionproductos;

import java.util.NoSuchElementException;

public class List<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    // Constructor
    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    // Verificar si está vacía
    public boolean estaVacia() {
        return size == 0;
    }

    // Agregar al final
    public void append(E data) {

        Node<E> nuevoNodo = new Node<>(data);

        if (estaVacia()) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            tail.next = nuevoNodo;
            tail = nuevoNodo;
        }

        size++;
    }

    // Agregar al inicio
    public void agregarAlInicio(E data) {

        Node<E> nuevoNodo = new Node<>(data);

        if (estaVacia()) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            nuevoNodo.next = head;
            head = nuevoNodo;
        }

        size++;
    }

    // Recorrer la lista
    public void recorrer() {

        Node<E> actual = head;

        while (actual != null) {
            System.out.println(actual.data);
            actual = actual.next;
        }
    }

    // Obtener elemento por posición
    public E obtenerEnPosicion(int i) {

        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(
                    "Posición inválida: " + i
            );
        }

        Node<E> actual = head;

        for (int pos = 0; pos < i; pos++) {
            actual = actual.next;
        }

        return actual.data;
    }

    // Buscar elemento
    public boolean buscar(E valor) {

        Node<E> actual = head;

        while (actual != null) {

            if (actual.data.equals(valor)) {
                return true;
            }

            actual = actual.next;
        }

        return false;
    }

    // Tamaño
    public int tamanio() {
        return size;
    }

    // Primer elemento
    public E primero() {

        if (estaVacia()) {
            throw new NoSuchElementException("Lista vacía");
        }

        return head.data;
    }

    // Último elemento
    public E ultimo() {

        if (estaVacia()) {
            throw new NoSuchElementException("Lista vacía");
        }

        return tail.data;
    }
}