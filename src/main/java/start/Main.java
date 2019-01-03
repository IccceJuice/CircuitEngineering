package start;

import controller.MainController;
import model.Graph.ChainGraph;
import model.Graph.Graph;
import model.Vertex.Vertex;

import java.util.*;

public class Main  {


    public static void main(String[] args) {

        Graph chainGraph = new ChainGraph();
        chainGraph.setGraph(new ArrayList<Vertex>());
        MainController.main(args, chainGraph);
    }
}
