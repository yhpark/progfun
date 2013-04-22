package patmat

import patmat.Huffman._

object ws {
  Huffman.sampleTree                              //> res0: patmat.Huffman.Fork = Fork(Fork(Leaf(x,1),Leaf(e,1),List(x, e),2),Leaf(
                                                  //| t,2),List(x, e, t),4)

  val bananaFreq = Huffman.times(Huffman.string2Chars("banana"))
                                                  //> bananaFreq  : List[(Char, Int)] = List((n,2), (b,1), (a,3))
  Huffman.createCodeTree(Huffman.string2Chars("banana"))
                                                  //> res1: patmat.Huffman.CodeTree = Fork(Fork(Leaf(b,1),Leaf(n,2),List(b, n),3),
                                                  //| Leaf(a,3),List(b, n, a),6)

  val french = Huffman.decodedSecret              //> french  : List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
  val enc = Huffman.quickEncode(Huffman.createCodeTree(Huffman.string2Chars("banana")))(Huffman.string2Chars("banana"))
                                                  //> enc  : List[patmat.Huffman.Bit] = List(0, 0, 1, 0, 1, 1, 0, 1, 1)

  val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
                                                  //> t1  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
  val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
                                                  //> t2  : patmat.Huffman.Fork = Fork(Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),Leaf
                                                  //| (d,4),List(a, b, d),9)

  val c = "ssssommmmeeeTTTTTTextftx".toList       //> c  : List[Char] = List(s, s, s, s, o, m, m, m, m, e, e, e, T, T, T, T, T, T,
                                                  //|  e, x, t, f, t, x)
  makeOrderedLeafList(times(c))                   //> res2: List[patmat.Huffman.Leaf] = List(Leaf(o,1), Leaf(f,1), Leaf(x,2), Leaf
                                                  //| (t,2), Leaf(s,4), Leaf(m,4), Leaf(e,4), Leaf(T,6))

  createCodeTree(c)                               //> res3: patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Leaf(o,1),Leaf(f,1),List
                                                  //| (o, f),2),Leaf(m,4),List(o, f, m),6),Leaf(e,4),List(o, f, m, e),10),Fork(Lea
                                                  //| f(x,2),Leaf(t,2),List(x, t),4),List(o, f, m, e, x, t),14)
  val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
                                                  //> leaflist  : List[patmat.Huffman.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,4)
                                                  //| )
  combine(leaflist)                               //> res4: List[patmat.Huffman.CodeTree] = List(Fork(Leaf(e,1),Leaf(t,2),List(e, 
                                                  //| t),3))
  val tree = createCodeTree("ab".toList)          //> tree  : patmat.Huffman.CodeTree = Fork(Leaf(b,1),Leaf(a,1),List(b, a),2)
  convert(tree)                                   //> res5: patmat.Huffman.CodeTable = List((b,List(0)), (a,List(1)))
  makeOrderedLeafList(times("ab".toList))         //> res6: List[patmat.Huffman.Leaf] = List(Leaf(b,1), Leaf(a,1))
  encode(tree)("ab".toList)                       //> res7: List[patmat.Huffman.Bit] = List(1, 0)
}