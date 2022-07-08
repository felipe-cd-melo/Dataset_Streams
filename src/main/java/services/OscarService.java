package services;

import model.OscarsWinners;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OscarService {
    private final List<OscarsWinners> oscarsData;

    public OscarService(List<OscarsWinners> oscarsData) {
        this.oscarsData = oscarsData;
    }

    public void printData(){
        oscarsData.stream()
        .forEach(o -> System.out.println(o.toString()));
    }

    public void printYoungest() {
        var youngestActor = oscarsData.stream()
                .min(Comparator.comparing(OscarsWinners::getAge))
                .get();

        oscarsData.stream()
                .filter(a -> a.getAge().equals(youngestActor.getAge()))
                .collect(Collectors.groupingBy(OscarsWinners::getName))
                .forEach((key, value) ->
                        System.out.printf("Nome: %-18s| Idade: %d %n", value.get(0).getName() , value.get(0).getAge(               )));

    }

    public void printMostAwarded() {
        var oscMax = oscarsData.stream()
                .collect(Collectors.groupingBy(OscarsWinners::getName))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue(Comparator.comparing(a-> a.size())))
                .get()
                .getValue().size();
        
        oscarsData.stream()
                .collect(Collectors.groupingBy(OscarsWinners::getName))
                .forEach((key, value) -> {
                    if(value.size() == oscMax){
                        System.out.printf("Nome: %-18s| prêmios: %d%n", key, value.size());
                    }
                });
     }

    public void printMostAwardedYoung() {
        var oscMax = oscarsData.stream()
                .filter(a -> a.getAge() >= 18 && a.getAge() <= 24)
                .collect(Collectors.groupingBy(OscarsWinners::getName))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue(Comparator.comparing(a-> a.size())))
                .get()
                .getValue().size();

        oscarsData.stream()
                .filter(a -> a.getAge() >= 18 && a.getAge() <= 24)
                .collect(Collectors.groupingBy(OscarsWinners::getName))
                .forEach((key, value) -> {
                    if(value.size() == oscMax){
                        System.out.printf("Nome: %-18s| prêmios: %d%n", key, value.size());
                    }
                });
    }
}
