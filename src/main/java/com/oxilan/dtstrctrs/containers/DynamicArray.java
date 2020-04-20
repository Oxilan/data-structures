package com.oxilan.dtstrctrs.containers;

public class DynamicArray<T> {

    long capacity = 10;
    public Object[] currentArray = new Object[(int) capacity];
    public int i;
    private Object[] newArray;


    public void add(Object element) {
        if (checkSize()) {
            currentArray[i] = element;
            i++;
        } else {
            createNewArray();
            copyArray();
            add(element);
        }

    }

    private boolean checkSize() {
        return i < currentArray.length ? true : false;
    }

    private boolean checkSize(int n) {
        return n + i < currentArray.length ? true : false;
    }

    private void createNewArray() {
        capacity = capacity + (Math.round(capacity * 0.5));
        newArray = new Object[(int) capacity];
    }

    private void createNewArray(int n) {
        capacity = n + capacity + (Math.round(capacity * 0.5));
        newArray = new Object[(int) capacity];
    }

    private void copyArray() {
        for (int j = 0; j < currentArray.length; j++) {
            newArray[j] = currentArray[j];
        }
        currentArray = newArray;
        newArray = null;
    }

    public int size() {
        return (int) i;
    }

    public void add(int n, Object object) {
        if (checkSize()) {
            for (int j = i; j >= n; j--) {
                currentArray[j + 1] = currentArray[j];
            }
            currentArray[n] = object;
            i++;
        } else {
            createNewArray();
            copyArray();
            add(n, object);
        }
    }

    public void addArray(Object[] arrayInsert) {
        if (checkSize(arrayInsert.length)) {
            for (int j = 0; j < arrayInsert.length; j++) {
                currentArray[i] = arrayInsert[j];
                i++;
            }
        } else {
            createNewArray(arrayInsert.length);
            copyArray();
            addArray(arrayInsert);
        }
    }

    public void addArray(Object[] arrayInsert, int index) {

        if (checkSize(arrayInsert.length)) {
            for (int j = i; j >= index; j--) {
                currentArray[j + arrayInsert.length] = currentArray[j];
            }
            i = i + arrayInsert.length;
            int j = 0;
            while (j < arrayInsert.length) {
                for (int d = index + arrayInsert.length; index < d; index++) {
                    currentArray[index] = arrayInsert[j];
                    j++;
                }
            }
        } else {
            createNewArray(arrayInsert.length);
            copyArray();
            addArray(arrayInsert, index);
        }

    }

    public void removeElement(Object element) {
        for (int j = 0; j < currentArray.length; j++) {
            if (currentArray[j].equals(element)) {
                currentArray[j] = null;
                for (int k = 1 + j; k < currentArray.length; k++) {
                    currentArray[j] = currentArray[k];
                    j++;
                }
                break; // удалять толко первое вхождение
            }
        }
        i--;
    }

    public void removeElement(int index) {
        currentArray[index] = null;
        for (int j = index; j < currentArray.length; j++) {
            for (int k = j + 1; k < currentArray.length; k++) {
                currentArray[j] = currentArray[k];

                break;
            }
        }
        i--;
    }
}
