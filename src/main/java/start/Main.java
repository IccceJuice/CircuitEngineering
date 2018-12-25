package start;

import controller.MainController;
import controller.VIew.VertexView;
import model.ChainGraph;
import model.Graph;
import model.Vertex;

import java.util.*;

public class Main  {


    public static void main(String[] args) {

        Graph chainGraph = new ChainGraph();
        chainGraph.setGraph(new ArrayList<Vertex>());
        MainController.main(args, chainGraph);
    }
}
