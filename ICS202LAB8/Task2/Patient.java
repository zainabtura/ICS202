import java.util.*;

public class Patient implements Comparable<Patient> {
    private String name;
    private int emergencyLevel;

    public Patient(String name, int emergencyLevel) {
        this.name = name;
        this.emergencyLevel = emergencyLevel;
    }

    public String getName() {
        return name;
    }

    public int getEmergencyLevel() {
        return emergencyLevel;
    }

    @Override
    public int compareTo(Patient other) {
        if (this.emergencyLevel != other.emergencyLevel) {
            return Integer.compare(this.emergencyLevel, other.emergencyLevel);
        } else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", emergencyLevel=" + emergencyLevel +
                '}';
    }
}
