import mappers.OscarMapper;
import model.OscarsWinners;
import model.SexType;
import services.OscarService;
import utils.FileUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App 
{
    public static void main( String[] args ) throws IOException {

        var fileUtilOscarMale = new FileUtil<OscarsWinners>("oscar_age_male.csv");
        var dadosOscarMale = fileUtilOscarMale.readFile(new OscarMapper(SexType.MALE));

        var fileUtilOscarFemale = new FileUtil<OscarsWinners>("oscar_age_female.csv");
        var dadosOscarFemale = fileUtilOscarFemale.readFile(new OscarMapper(SexType.FEMALE));

        var dadosOscar = Stream.concat(dadosOscarFemale.stream(), dadosOscarMale.stream())
                .sorted(Comparator.comparing(OscarsWinners::getYear))
                .collect(Collectors.toList());

        var oscarService = new OscarService(dadosOscar);
        //oscarService.printData();

        // 1- Quem é o ator ou atriz mais jovem a ser premiado?
        System.out.println("Ator ou atriz mais jovem a ser premiado:");
        oscarService.printYoungest();
        System.out.println();

        // 2- Quem foi o ator ou atriz mais premiado?
        System.out.println("Ator ou atriz com maior quantidade de premios");
        oscarService.printMostAwarded();
        System.out.println();

        // 3- Quem foi o jovem mais premiado (entre 18 e 24 anos)?
        System.out.println("Jovem mais premiado (entre 18 e 24 anos)");
        oscarService.printMostAwardedYoung();
        System.out.println();
    }
}
