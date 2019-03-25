package by.epam.javawebtraining.maksimkosmachev.task04.model.controller;


import by.epam.javawebtraining.maksimkosmachev.task04.ParcerKind;
import by.epam.javawebtraining.maksimkosmachev.task04.model.logic.Sorter;
import by.epam.javawebtraining.maksimkosmachev.task04.model.parser.ParcerChain;


public class Controller {

    public static void launch(){
      Sorter.sortSentenceByLength(ParcerChain.setChain(ParcerKind.PARAGRAF)).toString();

    }

}
