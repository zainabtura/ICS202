import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        PriorityQueue<Patient> patientHeap = new PriorityQueue<>();
        Random random = new Random();

        // Enqueue patients into the binary heap (PriorityQueue)
        patientHeap.add(new Patient("Sun-40", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Ali-63", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Sun-6", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Tom-26", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Tom-84", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Pat-84", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Sun-24", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Ali-7", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Bert-3", random.nextInt(5) + 1));
        patientHeap.add(new Patient("Rais-45", random.nextInt(5) + 1));

        // Heapsort: Remove patients from the heap and print them in sorted order
        System.out.println("The TREATMENT order of patients is>> ");
        while (!patientHeap.isEmpty()) {
            Patient p = patientHeap.poll(); // This removes the patient with the highest priority
            System.out.println("Patient Name>> " + p.getName() + ", Emergency Level>> " + p.getEmergencyLevel());
        }
    }
}


