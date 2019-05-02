public class ArrayList<T> {

    private int[] array;
    private int size;

    public ArrayList(int sizeReserve) {
        array = new int[sizeReserve];
        size = 0;
    }

    public int get(int idx) throws ArrayListIndexOutOfBoundsException {
        if (idx >= size) {
            throw new ArrayListIndexOutOfBoundsException(idx);
        } else {
            return array[idx];
        }
    }

    public void set(int value, int idx) {
        if (idx >= size) {
            throw new ArrayListIndexOutOfBoundsException(idx);
        } else {
            array[idx] = value;
        }
    }

    public int size() {
        return this.size;
    }

    public void addFirst(int value) {
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = value;
        size++;
    }

    public void addLast(int value) {
        array[size] = value;
        size++;
    }

    public void insertBefore(int value, int idx) {
        for (int i = size; i >= idx; i--) {
            array[i] = array[i - 1];
        }
        array[idx] = value;
        size++;
    }

    public void remove(int idx) {
        if (idx >= size) {
            throw new ArrayListIndexOutOfBoundsException(idx);
        } else {
            for (int j = idx; j < size; j++) {
                array[j] = array[j + 1];
            }
            size--;
        }
    }

}
