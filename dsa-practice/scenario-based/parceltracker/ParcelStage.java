package parceltracker;

public class ParcelStage {

    String stageName;
    ParcelStage next;   // reference to next stage

    public ParcelStage(String stageName) {
        this.stageName = stageName;
        this.next = null;
    }
}
