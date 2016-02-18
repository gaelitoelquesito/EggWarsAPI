package es.minetsii.eggwars.specialitems;

import java.util.Map;

import es.minetsii.eggwars.objects.EwPlayer;



public interface SpecialExecutor {

    public EwPlayer getPlayer();
    
    public void stop();
    
    public boolean isStopped();
    
    public Map<String, String> getExtra();

}
