package entities.appointment;

import java.util.Objects;

public class Treatment {
    private String name;
    private String recommendations;
    private int duration;
    private int cost;
    private int treatment_id;


    public Treatment() {

    }

    public Treatment(String name, int duration, int cost, String recommendations) {
        this.cost = cost;
        this.duration = duration;
        this.name = name;
        this.recommendations = recommendations;
    }

    public int getTreatment_id() {
        return treatment_id;
    }

    public void setTreatment_id(int treatment_id) {
        this.treatment_id = treatment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public String toString() {
        return "The Treatment " + this.name + " cost" + this.cost + " and lasts " + this.duration;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;

        Treatment treatment = (Treatment) object;
        return duration == treatment.duration && cost == treatment.cost &&
                treatment_id == treatment.treatment_id &&
                Objects.equals(name, treatment.name) &&
                Objects.equals(recommendations, treatment.recommendations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, recommendations, duration, cost, treatment_id);
    }
}
