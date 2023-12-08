class Entry<T> {
    private T dataObject;
    private String status;

    public Entry() {
        this.status = "E"; // Initially, the entry is empty
    }

    //changes the status to "O" (occupied).
    public void setDataObject(T dataObject) {
        this.dataObject = dataObject;
        this.status = "O"; // Mark as occupied
    }

    //Marks the entry as deleted
    public void setDeleted() {
        this.status = "D"; // Mark as deleted
    }

    public T getDataObject() {
        return dataObject;
    }

    public String getStatus() {
        return status;
    }

    // Returns the hash code of the dataObject. If dataObject is null, it returns 0.
    public int hash() {
        return dataObject != null ? dataObject.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "[" + (dataObject != null ? dataObject.toString() : "null") + ",\"" + status + "\"]";
    }
}
class HashTable<T> {
    private Entry<T>[] table;
    private int size;
    //Initializes the table array with size number of Entry objects, all initially empty.
    public HashTable(int size) {
        this.size = size;
        table = new Entry[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Entry<>();
        }
    }
    //It calculates the hash, finds the next available slot using findNextAvailableSlot, and inserts the object if a slot is available.
    public boolean insert(T dataObject) {
        int hash = Math.abs(dataObject.hashCode()) % size;
        int slot = findNextAvailableSlot(hash);
        if (slot == -1) {
            return false;
        }
        table[slot].setDataObject(dataObject);
        return true;
    }
    //Finds the next available slot using linear probing.
    public int findNextAvailableSlot(int currentSlot) {
        for (int i = 0; i < size; i++) {
            int slot = (currentSlot + i) % size;
            if (table[slot].getStatus().equals("E") || table[slot].getStatus().equals("D")) {
                return slot;
            }
        }
        return -1;
    }

    public boolean delete(T dataObject) {
        int index = find(dataObject);
        if (index != -1) {
            table[index].setDeleted();
            return true;
        }
        return false;
    }

    public int find(T dataObject) {
        int hash = Math.abs(dataObject.hashCode()) % size;
        for (int i = 0; i < size; i++) {
            int slot = (hash + i) % size;
            Entry<T> entry = table[slot];
            if (entry.getStatus().equals("O") && entry.getDataObject().equals(dataObject)) {
                return slot;
            }
            if (entry.getStatus().equals("E")) {
                break;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ").append(table[i].toString()).append("\n");
        }
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        HashTable<Integer> hashtable = new HashTable<>(13);

        hashtable.insert(18);
        hashtable.insert(26);
        hashtable.insert(35);
        hashtable.insert(9);

        System.out.println("After inserting 18, 26, 35, and 9, the hashtable is:");
        System.out.println(hashtable);
        String str1 = new String(" ");
        String str2 = new String(" ");
        String str3 = new String(" ");

        int result1 = hashtable.find(15);

        int result2 = hashtable.find(48);
        if (result1 == -1)
            str1 = "not";
        System.out.println("15 " + str1 + " found");
        if (result1 == -1)
            str2 = "not";
        System.out.println("48 " + str2 + " found");

        boolean deleteResult = hashtable.delete(35);
        hashtable.insert(64);
        hashtable.insert(47);
        if (deleteResult) {
            System.out.println("35 successfully deleted");
        } else {
            System.out.println("35 not found");
        }
        int result3 = hashtable.find(9);
        if (result3 != -1) {
            System.out.println("9 found at " + result3);
        } else {
            System.out.println("9 not found");
        }

        System.out.println("\nAfter deleting 35 and inserting 64 and 47, the hashtable is:");
        System.out.println(hashtable);

        result1 = hashtable.find(35);
        if (result1 == -1)
            str3 = "not";

        System.out.println("35 " + str3 + " found");
    }
}

