# DesignPatterns

## Adapter Pattern

When we need to translate one interface of a class to another interface.

Steps followed are 

1. Create an adapter class and implement the first interface whose adapter is to be made.

2. Create a reference of the other interface in the adapter class.

Example, say we have 2 interfaces

   1. USPlug
   2. UKPlug
    
    interface USPlug {
        void plugToUSPowerPoint();
    }
    
    interface UKPlug {
        void plugToUKPowerPoint();
    }
    

We have 2 laptop which is of US and UK respectively.
   
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

Now when the laptop are used in their respective countries, then there are no issues.

But if US Laptop is being used in UK. We need an dapter.

    class UKAdapter implements USPlug {
        private UKPlug UKPlug;
    
        public UKAdapter(UKPlug UKPlug) {
            this.UKPlug = UKPlug;
        }
    
        public void plugToUSPowerPoint() {
            UKPlug.plugToUKPowerPoint();
        }
    }
    
so that when we use a Us Laptop in UK, we can use the UK Adaptor as below.

    public static void main(String[] args) {
            USPlug usPlug = new LapTopInUS();
            usPlug.plugToUSPowerPoint();
    
            UKPlug ukPlug = new LaptopInUK();
            ukPlug.plugToUKPowerPoint();
    
            UKAdapter UKAdapter = new UKAdapter(ukPlug);
            UKAdapter.plugToUSPowerPoint();
        }
        
        
    o/p will be as below.
    
    Plugging to US Power point
    Plugging to UK Power point
    Plugging to UK Power point