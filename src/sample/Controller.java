package sample;
        import javafx.application.Platform;
        import javafx.scene.control.TextArea;

        import java.util.Stack;

public class Controller {
    private  final AdjacencyGraph model;
    private  final DijkstraFormView view;
    public Controller(AdjacencyGraph GraphModel, DijkstraFormView DijkstraView){
        this.model = GraphModel;
        this.view = DijkstraView;
        view.exitBtn.setOnAction(e-> Platform.exit());
        view.DijkstraBtn.setOnAction(e->model.Dijkstra(view.startVertexComB.getValue()));
    }

    public void HandlePrintRequest(Vertex destination, TextArea TArea) {
        Vertex pvertex = destination;
        TArea.appendText("To " + destination.Name + " Shortest length: " + destination.distance);
        Stack<Vertex> Path = new Stack<>();
        int limit =0;
        while (pvertex!=null)
        {
            Path.push(pvertex);
            pvertex = pvertex.prev;
        }
        if (!Path.isEmpty())
            limit = Path.size();
        for (int i=0; i<limit -1; i++)
            TArea.appendText(Path.pop().Name + " -> ");
        if (limit >0)
            TArea.appendText(Path.pop().Name);
    }
}