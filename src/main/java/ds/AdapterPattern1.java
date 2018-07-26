package ds;

interface USPlug {
    void plugToUSPowerPoint();
}

interface UKPlug {
    void plugToUKPowerPoint();
}

/**
 * Created by Adwiti on 7/26/2018.
 */

class LapTopInUS implements USPlug {
    public void plugToUSPowerPoint() {
        System.out.println("Plugging to US Power point");
    }
}

class LaptopInUK implements UKPlug {
    public void plugToUKPowerPoint() {
        System.out.println("Plugging to UK Power point");
    }
}

class UKAdapter implements USPlug {
    private UKPlug UKPlug;

    public UKAdapter(UKPlug UKPlug) {
        this.UKPlug = UKPlug;
    }

    public void plugToUSPowerPoint() {
        UKPlug.plugToUKPowerPoint();
    }
}

public class AdapterPattern1 {

    public static void main(String[] args) {
        USPlug usPlug = new LapTopInUS();
        usPlug.plugToUSPowerPoint();

        UKPlug ukPlug = new LaptopInUK();
        ukPlug.plugToUKPowerPoint();

        UKAdapter UKAdapter = new UKAdapter(ukPlug);
        UKAdapter.plugToUSPowerPoint();
    }
}


