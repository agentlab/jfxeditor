package ru.agentlab.jfxed.diagramms.clazz;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Resource;
import de.fxdiagram.core.XDiagram;
import de.fxdiagram.core.XNode;
import javafx.collections.ObservableList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import ru.agentlab.jfxed.IDiagram;
import ru.agentlab.jfxed.figures.clazz.ClassFigure;

@SuppressWarnings("all")
public class ClazzDiagram implements IDiagram {
  private static String SOURCE = "http://www.agentlab.ru/jfxed/onto/dma";
  
  private static String NS = (ClazzDiagram.SOURCE + "#");
  
  public void createJfx(final OntModel jenaModel, final XDiagram jfxDiagram) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> ");
    _builder.newLine();
    _builder.append("select ?uri ");
    _builder.newLine();
    _builder.append("where { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("?uri rdf:type <");
    _builder.append(ClazzDiagram.SOURCE, "\t");
    _builder.append("#greenOval> ");
    _builder.newLineIfNotEmpty();
    _builder.append("} ");
    _builder.newLine();
    final String queryString = _builder.toString();
    final Query query = QueryFactory.create(queryString);
    final QueryExecution qe = QueryExecutionFactory.create(query, jenaModel);
    final ResultSet results = qe.execSelect();
    for (; results.hasNext();) {
      {
        final QuerySolution soln = results.nextSolution();
        final Resource x = soln.getResource("uri");
        ClassFigure _classFigure = new ClassFigure();
        final Procedure1<ClassFigure> _function = new Procedure1<ClassFigure>() {
          public void apply(final ClassFigure it) {
            it.setLayoutX(280);
            it.setLayoutY(280);
            String _localName = x.getLocalName();
            it.setName(_localName);
          }
        };
        final ClassFigure target = ObjectExtensions.<ClassFigure>operator_doubleArrow(_classFigure, _function);
        final Procedure1<XDiagram> _function_1 = new Procedure1<XDiagram>() {
          public void apply(final XDiagram it) {
            ObservableList<XNode> _nodes = it.getNodes();
            _nodes.add(target);
          }
        };
        ObjectExtensions.<XDiagram>operator_doubleArrow(jfxDiagram, _function_1);
      }
    }
    qe.close();
  }
}
