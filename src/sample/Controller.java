package sample;
        import javafx.application.Platform;
public class Controller {
    private  final AdjacencyGraph model;
    private  final DijkstraFormView view;
    public Controller(AdjacencyGraph GraphModel, DijkstraFormView DijkstraView){
        this.model = GraphModel;
        this.view = DijkstraView;
        view.exitBtn.setOnAction(e-> Platform.exit());
        view.DijkstraBtn.setOnAction(e->model.Dijkstra(view.startVertexComB.getValue()));
    }
}