package fr.cailliaud.adventure.map;

import fr.cailliaud.adventure.map.domain.area.Area;
import fr.cailliaud.adventure.map.domain.Position;
import fr.cailliaud.adventure.map.domain.area.ClassicalArea;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class AdventureMap {

    private Area[][] structure;


    private AdventureMap(int length, int width){
        this.structure = new Area[length][width];
        initStructure( );
    }

    public Area getArea(Position p){
        if(structure.length > p.getX() && structure[p.getX()].length > p.getY()){
            return structure[p.getX()][p.getY()];
        }else{
            return null;
        }

    }

    private  void initStructure(){
        for(int x =0 ; x < structure.length; x++){
            for(int y=0; y < structure[x].length; y++){
                structure[x][y] = new ClassicalArea();
            }
        }
    }

    private void setArea(Position p, Area area){
        this.structure[p.getX()][p.getY()]=area;
    }

    public static class Builder{
        private int length;
        private int width;
        private Map<Position,Area> areas = new HashMap();


        public Builder withLength(int length){
            this.length=length;
            return this;
        }

        public Builder withWidth(int width){
            this.width=width;
            return this;
        }

        public Builder withAreas(Map<Position, Area> areas){
            this.areas=areas;
            return this;
        }

        public AdventureMap build(){


            AdventureMap map =  new AdventureMap(length,width);

            areas.entrySet().stream()
                    .filter( entry -> (entry.getKey().getX() >= 0  && entry.getKey().getX() < length))
                    .filter( entry -> (entry.getKey().getY() >= 0  && entry.getKey().getY() < width))
                    .forEach(entry -> map.setArea(entry.getKey(),entry.getValue()));

            return map;
        }
    }

    public void displayMap(){
        for(int x =0 ; x < structure.length; x++){
            for(int y=0; y < structure[x].length; y++){
                if(!structure[x][y].getClass().equals(ClassicalArea.class)){
                    System.out.println(structure[x][y].getClass().getSimpleName()+" - "+x+" - "+y);
                }

            }
        }
    }


}
