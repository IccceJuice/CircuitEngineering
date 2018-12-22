package start;

import controller.MainController;
import model.ChainGraph;
import model.Graph;
import model.Vertex;

import java.util.LinkedList;

public class Main  {


    public static void main(String[] args) {

        Graph chainGraph = new ChainGraph();
        chainGraph.setGraph(new LinkedList<Vertex>());
        MainController.main(args, chainGraph);
    }
}
