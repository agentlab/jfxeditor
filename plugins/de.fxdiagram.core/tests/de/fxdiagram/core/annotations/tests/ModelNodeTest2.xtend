package de.fxdiagram.core.annotations.tests

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.junit.Test

class ModelNodeTest2 {
	
	@Test 
	def void testProperties() {
		assertCompilesTo('''
			import de.fxdiagram.annotations.properties.ModelNode
			import de.fxdiagram.core.XShape
			
			@ModelNode(#['layoutX', 'layoutY']) 
			abstract class ModelTest21 extends XShape {
			}
		''', '''
			import de.fxdiagram.annotations.properties.ModelNode;
			import de.fxdiagram.core.model.ModelElementImpl;
			import de.fxdiagram.core.model.XModelProvider;
			import de.fxdiagram.core.XShape;
			
			@ModelNode({ "layoutX", "layoutY" })
			@SuppressWarnings("all")
			public abstract class ModelTest21 extends XShape implements XModelProvider {
			  public void populate(final ModelElementImpl modelElement) {
			    modelElement.addProperty(layoutXProperty(), Double.class);
			    modelElement.addProperty(layoutYProperty(), Double.class);
			  }
			}
		''')
	}
	
	protected def assertCompilesTo(CharSequence source, CharSequence target) {
		val compilerTester = XtendCompilerTester.newXtendCompilerTester(class)
		compilerTester.assertCompilesTo(source, target)
	}
}
