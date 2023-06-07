package efs.task.collections.data;

import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.*;
import java.util.stream.Collectors;

public class DataProvider {

    public static final String DATA_SEPARATOR = ",";

    // TODO Utwórz listę miast na podstawie tablicy Data.baseTownsArray.
    //  Tablica zawiera String zawierający nazwę miasta oraz dwie klasy bohatera związane z tym miastem oddzielone przecinkami.
    //  Korzystając z funkcji split() oraz stałej DATA_SEPARATOR utwórz listę obiektów klasy efs.task.collections.entities.Town.
    //  Funkcja zwraca listę obiektów typu Town ze wszystkimi dziewięcioma podstawowymi miastami.
    public List<Town> getTownsList() {
        List<Town> towns_list = new ArrayList<>();
        for (String town: Data.baseTownsArray) {
            String[] towns = town.split(DATA_SEPARATOR);
            List<String> heroClasses = Arrays.asList(towns[1].trim(), towns[2].trim());
            towns_list.add(new Town(towns[0].trim(), heroClasses));
        }
        return towns_list;
    }

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        List<Town> towns_list = new ArrayList<>();
        for (String town: Data.dlcTownsArray) {
            String[] towns = town.split(DATA_SEPARATOR);
            List<String> heroClasses = Arrays.asList(towns[1].trim(), towns[2].trim());
            towns_list.add(new Town(towns[0].trim(), heroClasses));
        }
        return towns_list;
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
        Set<Hero> heroesSet = new HashSet<>();

        for (String characterData : Data.baseCharactersArray) {
            String[] data = characterData.split(DATA_SEPARATOR);
            String name = data[0].trim();
            String heroClass = data[1].trim();
            Hero hero = new Hero(name, heroClass);
            heroesSet.add(hero);
        }
        return heroesSet;
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        Set<Hero> heroesSet = new HashSet<>();

        for (String characterData : Data.dlcCharactersArray) {
            String[] data = characterData.split(DATA_SEPARATOR);
            String name = data[0].trim();
            String heroClass = data[1].trim();
            Hero hero = new Hero(name, heroClass);
            heroesSet.add(hero);
        }
        return heroesSet;
    }
}
