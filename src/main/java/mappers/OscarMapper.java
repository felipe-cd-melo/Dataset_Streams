package mappers;

import model.OscarsWinners;
import model.SexType;

import java.util.function.Function;

public class OscarMapper implements Function<String, OscarsWinners> {
    SexType sex;
    public OscarMapper(SexType sex){
        this.sex= sex;
    }
    @Override
    public OscarsWinners apply(String line) {
        String[] dadosLinha = line.split(";");
        Long index = Long.parseLong(dadosLinha[0].strip());
        Integer year = Integer.parseInt(dadosLinha[1].strip());
        Integer age = Integer.parseInt(dadosLinha[2].strip());
        String name = dadosLinha[3].strip();
        String movie = dadosLinha[4].strip();

        return new OscarsWinners(index, year, age, name, movie,this.sex);
    }
}
