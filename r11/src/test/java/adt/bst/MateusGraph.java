package adt.bst;

import adt.bt.BT;
import adt.bt.BTNode;

public class MateusGraph {
	static int idCounter = 0;

	public String gerar(BT<Integer> tree) {
		StringBuilder builder = new StringBuilder();
		builder.append("subgraph {");
		gerarNode(builder, tree.getRoot());
		builder.append("}");
		return builder.toString();
	}

	private int gerarNode(StringBuilder builder, BTNode<Integer> node) {
		if (node.isEmpty())
			return -1;

		int id = idCounter++;
		builder.append(String.format("n%d [label=\"%d\"];", id, node.getData()));

		int left = gerarNode(builder, node.getLeft());
		if (left != -1)
			builder.append(String.format("n%d -- n%d [color=\"red\",label=\"L\"];", id, left));
		
		int right = gerarNode(builder, node.getRight());
		if (right != -1)
			builder.append(String.format("n%d -- n%d [label=\"R\"];", id, right));

		return id;
	}

	static void printar(BT<Integer> tree) {
		System.out.println(new MateusGraph().gerar(tree));
	}
}
