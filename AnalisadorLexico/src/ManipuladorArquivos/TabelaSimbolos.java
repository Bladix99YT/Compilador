package ManipuladorArquivos;

import java.util.HashMap;

public class TabelaSimbolos {
	public HashMap<String, Simbolo> tabela = new HashMap<>();
	public int end = -1;

	public static byte AND = 0;
	public static byte ARRAY = 1;
	public static byte BEGIN = 2;
	public static byte CASE = 3;
	public static byte CONST = 4;
	public static byte DIV = 5;
	public static byte DO = 6;
	public static byte REPEAT = 7;
	public static byte DOWNTO = 8;
	public static byte ELSE = 9;
	public static byte END = 10;
	public static byte FILE = 11;
	public static byte FOR = 12;
	public static byte FUNCTION = 13;
	public static byte GOTO = 14;
	public static byte IF = 15;
	public static byte IN = 16;
	public static byte LABEL = 17;
	public static byte MOD = 18;
	public static byte NIL = 19;
	public static byte NOT = 20;
	public static byte OF = 21;
	public static byte OR = 22;
	public static byte PACKET = 23;
	public static byte PROCEDURE = 24;
	public static byte SET = 25;
	public static byte THEN = 26;
	public static byte TO = 27;
	public static byte TYPE = 28;
	public static byte UNTIL = 29;
	public static byte VAR = 30;
	public static byte CONSTRUCTOR = 31;
	public static byte WITH = 32;
	public static byte PLUS = 33; // +
	public static byte LESS = 34; // -
	public static byte MULT = 35; // *
	public static byte DIVIDE = 36; // /
	public static byte EQUAL = 37; // =
	public static byte LESSTHAN = 38; // <
	public static byte MORETHAN = 39; // >
	public static byte LESSEQUAL = 40; // <=
	public static byte MOREEQUAL = 41; // >=
	public static byte DIFFERENT = 42; // <>
	public static byte OPPAR = 43; // )
	public static byte CLPAR = 44; // (
	public static byte OPCOL = 45; // [
	public static byte CLCOL = 46; // ]
	public static byte COMMA = 47; // ,
	public static byte DOTCOMMA = 48; // ;
	public static byte RECIEVE = 49; // :
	public static byte DOT = 50; // .
	public static byte INTERVAL = 51; // ..
	public static byte RECIEVETO = 52; // :=
	public static byte CLINTERVAL = 53; // ..=
	public static byte COMMENT = 54; // //
	public static byte OPCHA = 55; // {
	public static byte CLCHA = 56; // }
	public static byte POINT = 57; // ^
	public static byte ORS = 58; // |
	public static byte ARROBA = 59; // @
	public static byte DOLLAR = 60; // $
	public static byte SHARP = 61; // #
	public static byte ANDS = 62; // &
	public static byte PERCENT = 63; // %
	public static byte PROGRAM = 64;
	public static byte RECORD = 65;
	public static byte VIRTUAL = 66;
	public static byte ABSOLUTE = 67;
	public static byte ASM = 68;
	public static byte DESTRUCTOR = 69;
	public static byte EXPORT = 70;
	public static byte EXTERNAL = 71;
	public static byte FORWARD = 72;
	public static byte IMPLEMENTATION = 73;
	public static byte INHIRETED = 74;
	public static byte INLINE = 75;
	public static byte INTERFACE = 76;
	public static byte INTERRUPT = 77;
	public static byte LIBRARY = 78;
	public static byte SHL = 79;
	public static byte STRING = 80;
	public static byte USES = 81;
	public static byte XOR = 82;
	public static byte NUMBER = 83;

	public TabelaSimbolos() {
		// PALAVRAS RESERVADAS
		tabela.put("and", new Simbolo(AND, "and", ++end));
		tabela.put("array", new Simbolo(ARRAY, "array", ++end));
		tabela.put("begin", new Simbolo(BEGIN, "begin", ++end));
		tabela.put("case", new Simbolo(CASE, "case", ++end));
		tabela.put("const", new Simbolo(CONST, "const", ++end));
		tabela.put("div", new Simbolo(DIV, "div", ++end));
		tabela.put("do", new Simbolo(DO, "do", ++end));
		tabela.put("downto", new Simbolo(DOWNTO, "downto", ++end));
		tabela.put("else", new Simbolo(ELSE, "else", ++end));
		tabela.put("end", new Simbolo(END, "end", ++end));
		tabela.put("file", new Simbolo(FILE, "file", ++end));
		tabela.put("for", new Simbolo(FOR, "for", ++end));
		tabela.put("function", new Simbolo(FUNCTION, "function", ++end));
		tabela.put("goto", new Simbolo(GOTO, "goto", ++end));
		tabela.put("if", new Simbolo(IF, "if", ++end));
		tabela.put("in", new Simbolo(IN, "in", ++end));
		tabela.put("label", new Simbolo(LABEL, "label", ++end));
		tabela.put("mod", new Simbolo(MOD, "mod", ++end));
		tabela.put("nil", new Simbolo(NIL, "nil", ++end));
		tabela.put("not", new Simbolo(NOT, "not", ++end));
		tabela.put("of", new Simbolo(OF, "of", ++end));
		tabela.put("or", new Simbolo(OR, "or", ++end));
		tabela.put("packet", new Simbolo(PACKET, "packet", ++end));
		tabela.put("procedure", new Simbolo(PROCEDURE, "procedure", ++end));
		tabela.put("program", new Simbolo(PROGRAM, "program", ++end));
		tabela.put("record", new Simbolo(RECORD, "record", ++end));
		tabela.put("end", new Simbolo(END, "end", ++end));
		tabela.put("repeat", new Simbolo(REPEAT, "repeat", ++end));
		tabela.put("set", new Simbolo(SET, "set", ++end));
		tabela.put("then", new Simbolo(THEN, "then", ++end));
		tabela.put("to", new Simbolo(TO, "to", ++end));
		tabela.put("type", new Simbolo(TYPE, "type", ++end));
		tabela.put("until", new Simbolo(UNTIL, "until", ++end));
		tabela.put("var", new Simbolo(VAR, "var", ++end));
		tabela.put("virtual", new Simbolo(VIRTUAL, "virtual", ++end));
		tabela.put("with", new Simbolo(WITH, "with", ++end));
		tabela.put("constructor", new Simbolo(CONSTRUCTOR, "constructor", ++end));
		tabela.put("absolute", new Simbolo(ABSOLUTE, "absolute", ++end));
		tabela.put("asm", new Simbolo(ASM, "asm", ++end));
		tabela.put("destructor", new Simbolo(DESTRUCTOR, "destructor", ++end));
		tabela.put("export", new Simbolo(EXPORT, "export", ++end));
		tabela.put("external", new Simbolo(EXTERNAL, "external", ++end));
		tabela.put("forward", new Simbolo(FORWARD, "forward", ++end));
		tabela.put("implementation", new Simbolo(IMPLEMENTATION, "implementation", ++end));
		tabela.put("inhireted", new Simbolo(INHIRETED, "inhireted", ++end));
		tabela.put("inline", new Simbolo(INLINE, "inline", ++end));
		tabela.put("interface", new Simbolo(INTERFACE, "interface", ++end));
		tabela.put("interrupt", new Simbolo(INTERRUPT, "interrupt", ++end));
		tabela.put("library", new Simbolo(LIBRARY, "library", ++end));
		tabela.put("shl", new Simbolo(SHL, "shl", ++end));
		tabela.put("string", new Simbolo(STRING, "string", ++end));
		// Por motivos de simplicidade, vou considerar que exista somente NUMBER
		tabela.put("uses", new Simbolo(USES, "uses", ++end));
		tabela.put("xor", new Simbolo(XOR, "xor", ++end));

		// SÍMBOLOS
		tabela.put("+", new Simbolo(PLUS, "+", ++end));
		tabela.put("-", new Simbolo(LESS, "-", ++end));
		tabela.put("*", new Simbolo(MULT, "*", ++end));
		tabela.put("/", new Simbolo(DIVIDE, "/", ++end));
		tabela.put("=", new Simbolo(EQUAL, "=", ++end));
		tabela.put("<", new Simbolo(LESSTHAN, "<", ++end));
		tabela.put(">", new Simbolo(MORETHAN, ">", ++end));
		tabela.put("<=", new Simbolo(LESSEQUAL, "<=", ++end));
		tabela.put(">=", new Simbolo(MOREEQUAL, ">=", ++end));
		tabela.put("<>", new Simbolo(DIFFERENT, "<>", ++end));
		tabela.put("(", new Simbolo(OPPAR, "(", ++end));
		tabela.put(")", new Simbolo(CLPAR, ")", ++end));
		tabela.put("[", new Simbolo(OPCOL, "[", ++end));
		tabela.put("]", new Simbolo(CLCOL, "]", ++end));
		tabela.put(",", new Simbolo(COMMA, ",", ++end));
		tabela.put(";", new Simbolo(DOTCOMMA, ";", ++end));
		tabela.put(":", new Simbolo(RECIEVE, ":", ++end));
		tabela.put(".", new Simbolo(DOT, ".", ++end));
		tabela.put("..", new Simbolo(INTERVAL, "..", ++end));
		tabela.put(":=", new Simbolo(RECIEVETO, ":=", ++end));
		tabela.put("..=", new Simbolo(CLINTERVAL, "..=", ++end));
		tabela.put("//", new Simbolo(COMMENT, "//", ++end));
		tabela.put("{", new Simbolo(OPCHA, "{", ++end));
		tabela.put("}", new Simbolo(CLCHA, "}", ++end));
		tabela.put("^", new Simbolo(POINT, "^", ++end));
		tabela.put("|", new Simbolo(ORS, "|", ++end));
		tabela.put("@", new Simbolo(ARROBA, "@", ++end));
		tabela.put("$", new Simbolo(DOLLAR, "$", ++end));
		tabela.put("#", new Simbolo(SHARP, "#", ++end));
		tabela.put("&", new Simbolo(ANDS, "&", ++end));
		tabela.put("%", new Simbolo(PERCENT, "%", ++end));
	}

	public int Pesquisar(String lexema) {
		lexema = lexema.toLowerCase();
		Simbolo aux = tabela.get(lexema);
		return aux.getEndereco();
	}

	public Simbolo BuscarSimbolo(String lexema) {
		lexema = lexema.toLowerCase();
		return tabela.get(lexema);
	}

	public Simbolo InserirID(String lexema, byte ID) {
		lexema = lexema.toLowerCase();
		Simbolo simbolo = new Simbolo(ID, lexema, ++end);
		tabela.put(lexema, simbolo);
		return tabela.get(lexema);
	}

	public Simbolo inserirConst(String lexema, String tipo) {
		lexema = lexema.toLowerCase();
		Simbolo simbolo = new Simbolo(CONST, lexema, tipo, ++end);
		tabela.put(lexema, simbolo);
		return tabela.get(lexema);
	}

	public final boolean contains(String caractere) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'contains'");
	}

	public final void InserirID(String palavra, int nLine) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'InserirID'");
	}

}
