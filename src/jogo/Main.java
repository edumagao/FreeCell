/*	Autores:
 * 			Eduardo Vinícius
 * 			Leonardo Côelho 
*/
package jogo;

//Importações
import jogo.Stack;
import jogo.Baralho;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.effect.*;


public class Main extends Application {

	//Variáveis
	static int width = 1000;
	static int height = 700;
	static int heightRect = 120;
	static int widthRect = 92;
	static int widthB = 80;
	static int heightB = 30;

	static int heightBL = 140;

	LinkedList<Baralho> list = new LinkedList<>();
	LinkedList<Baralho> embaralhado = new LinkedList<>();

	static double x1 = 70;
	static double x2 = 174;
	static double x3 = 277;
	static double x4 = 385;
	static double x5 = 487;
	static double x6 = 592;
	static double x7 = 695;
	static double x8 = 800;

	static double y1 = 200;
	static double y2 = 200;
	static double y3 = 200;
	static double y4 = 200;
	static double y5 = 200;
	static double y6 = 200;
	static double y7 = 200;
	static double y8 = 200;

	//variável usada para receber a carta a ser removida da pilha
	static ImageView selectedCard;
	
	//variáveis que recebem as informações da carta removida
	//afim de saber se elas podem ir pra outra pilha
	static int suit;
	static int value;
	static int back;

	static int red = 0;
	static int black = 1;

	static int diamond = 1;
	static int hearts = 1;
	static int spades = 1;
	static int clubs = 1;

	//Instanciando as pilhas 
	Stack<ImageView> pilha1 = new Stack<>();
	Stack<ImageView> pilha2 = new Stack<>();
	Stack<ImageView> pilha3 = new Stack<>();
	Stack<ImageView> pilha4 = new Stack<>();
	Stack<ImageView> pilha5 = new Stack<>();
	Stack<ImageView> pilha6 = new Stack<>();
	Stack<ImageView> pilha7 = new Stack<>();
	Stack<ImageView> pilha8 = new Stack<>();

	//Gerenciadores de layout
	AnchorPane central = new AnchorPane();

	AnchorPane anchor1 = new AnchorPane();
	AnchorPane anchor2 = new AnchorPane();
	AnchorPane anchor3 = new AnchorPane();
	AnchorPane anchor4 = new AnchorPane();
	AnchorPane anchor5 = new AnchorPane();
	AnchorPane anchor6 = new AnchorPane();
	AnchorPane anchor7 = new AnchorPane();
	AnchorPane anchor8 = new AnchorPane();

	AnchorPane anchorBL1 = new AnchorPane();
	AnchorPane anchorBL2 = new AnchorPane();
	AnchorPane anchorBL3 = new AnchorPane();
	AnchorPane anchorBL4 = new AnchorPane();

	AnchorPane anchorBR1 = new AnchorPane();
	AnchorPane anchorBR2 = new AnchorPane();
	AnchorPane anchorBR3 = new AnchorPane();
	AnchorPane anchorBR4 = new AnchorPane();

	static ImageView imageView1;
	static ImageView imageView2;
	static ImageView imageView3;
	static ImageView imageView4;
	
	Reflection reflection = new Reflection();

	//Função para adicionar as imagens dos naipes na pilha definitiva
	public void addSuits() throws FileNotFoundException {
		FileInputStream inputstream1 = new FileInputStream(
				"C:\\Users\\eduar\\Desktop\\Programação\\Programas Java\\cards\\suits\\diamonds.png");
		Image image1 = new Image(inputstream1);
		imageView1 = new ImageView(image1);
		imageView1.setFitHeight(120);
		imageView1.setFitWidth(92);
		imageView1.setX(505);
		imageView1.setY(10);

		FileInputStream inputstream2 = new FileInputStream(
				"C:\\Users\\eduar\\Desktop\\Programação\\Programas Java\\cards\\suits\\hearts.png");
		Image image2 = new Image(inputstream2);
		imageView2 = new ImageView(image2);
		imageView2.setFitHeight(120);
		imageView2.setFitWidth(92);
		imageView2.setX(620);
		imageView2.setY(10);

		FileInputStream inputstream3 = new FileInputStream(
				"C:\\Users\\eduar\\Desktop\\Programação\\Programas Java\\cards\\suits\\spades.png");
		Image image3 = new Image(inputstream3);
		imageView3 = new ImageView(image3);
		imageView3.setFitHeight(120);
		imageView3.setFitWidth(92);
		imageView3.setX(733);
		imageView3.setY(10);

		FileInputStream inputstream4 = new FileInputStream(
				"C:\\Users\\eduar\\Desktop\\Programação\\Programas Java\\cards\\suits\\clubs.png");
		Image image4 = new Image(inputstream4);
		imageView4 = new ImageView(image4);
		imageView4.setFitHeight(120);
		imageView4.setFitWidth(92);
		imageView4.setX(848);
		imageView4.setY(10);
	}

	//Função para adicionar as cartas no jogo
	//O nome de cada imagem é seu respectivo número então
	//é usado a variável "i" para otimizar 
	public void adicionar() throws FileNotFoundException {

		for (int i = 1; i <= 13; i++) {
			//Instanciando a classe Baralho para "setar" as cartas
			Baralho deck = new Baralho();

			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\eduar\\Desktop\\Programação\\Programas Java\\cards\\diamonds\\" + i + ".png");
			Image image = new Image(inputstream);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(92);
			deck.setContainer(imageView);
			deck.setValue(i);
			deck.setSuit(0);

			//Adicionando as cartas na LinkedList
			embaralhado.add(deck);
		}

		for (int i = 1; i <= 13; i++) {
			Baralho deck = new Baralho();

			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\eduar\\Desktop\\Programação\\Programas Java\\cards\\hearts\\" + i + ".png");
			Image image = new Image(inputstream);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(92);
			deck.setContainer(imageView);
			deck.setValue(i);
			deck.setSuit(1);

			embaralhado.add(deck);
		}

		for (int i = 1; i <= 13; i++) {
			Baralho deck = new Baralho();

			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\eduar\\Desktop\\Programação\\Programas Java\\cards\\spades\\" + i + ".png");
			Image image = new Image(inputstream);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(92);
			deck.setContainer(imageView);
			deck.setValue(i);
			deck.setSuit(2);

			embaralhado.add(deck);
		}

		for (int i = 1; i <= 13; i++) {
			Baralho deck = new Baralho();

			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\eduar\\Desktop\\Programação\\Programas Java\\cards\\clubs\\" + i + ".png");
			Image image = new Image(inputstream);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(92);
			deck.setContainer(imageView);
			deck.setValue(i);
			deck.setSuit(3);

			embaralhado.add(deck);
		}

	}

	//Função usada para embaralhar as cartas, fazendo com que
	//fiquem aleatórias nas pilhas
	public void embaralhar() {
		Random random = new Random();
		int num1;

		for (int i = 52; i > 0; i--) {
			num1 = random.nextInt(i);
			list.add(embaralhado.remove(num1));
		}
	}

	//Adicionando as cartas nos gerenciadores de layout e nas pilhas
	//para poderem aparecer visualmente no programa
	@SuppressWarnings("static-access")
	public void empilhar() {
		Random random2 = new Random();
		int num2;

		for (int i = 51; i >= 0; i--) {
			num2 = random2.nextInt(8);

			switch (num2) {
			case 0:
				pilha1.empilha(list.get(i).getContainer());
				anchor1.getChildren().add(list.get(i).getContainer());
				anchor1.setTopAnchor(list.get(i).getContainer(), y1);
				anchor1.setLeftAnchor(list.get(i).getContainer(), x1);

				y1 += 20;

				break;
			case 1:
				pilha2.empilha(list.get(i).getContainer());
				anchor2.getChildren().add(list.get(i).getContainer());
				anchor2.setTopAnchor(list.get(i).getContainer(), y2);
				anchor2.setLeftAnchor(list.get(i).getContainer(), x2);

				y2 += 20;

				break;
			case 2:
				pilha3.empilha(list.get(i).getContainer());
				anchor3.getChildren().add(list.get(i).getContainer());
				anchor3.setTopAnchor(list.get(i).getContainer(), y3);
				anchor3.setLeftAnchor(list.get(i).getContainer(), x3);

				y3 += 20;

				break;
			case 3:
				pilha4.empilha(list.get(i).getContainer());
				anchor4.getChildren().add(list.get(i).getContainer());
				anchor4.setTopAnchor(list.get(i).getContainer(), y4);
				anchor4.setLeftAnchor(list.get(i).getContainer(), x4);

				y4 += 20;

				break;
			case 4:
				pilha5.empilha(list.get(i).getContainer());
				anchor5.getChildren().add(list.get(i).getContainer());
				anchor5.setTopAnchor(list.get(i).getContainer(), y5);
				anchor5.setLeftAnchor(list.get(i).getContainer(), x5);

				y5 += 20;

				break;
			case 5:
				pilha6.empilha(list.get(i).getContainer());
				anchor6.getChildren().add(list.get(i).getContainer());
				anchor6.setTopAnchor(list.get(i).getContainer(), y6);
				anchor6.setLeftAnchor(list.get(i).getContainer(), x6);

				y6 += 20;

				break;
			case 6:
				pilha7.empilha(list.get(i).getContainer());
				anchor7.getChildren().add(list.get(i).getContainer());
				anchor7.setTopAnchor(list.get(i).getContainer(), y7);
				anchor7.setLeftAnchor(list.get(i).getContainer(), x7);

				y7 += 20;

				break;
			case 7:
				pilha8.empilha(list.get(i).getContainer());
				anchor8.getChildren().add(list.get(i).getContainer());
				anchor8.setTopAnchor(list.get(i).getContainer(), y8);
				anchor8.setLeftAnchor(list.get(i).getContainer(), x8);

				y8 += 20;

				break;

			}
		}
	}

	//Função chamada para receber a carta a ser removida da pilha
	//afim de transferi-la para outra pilha
	public boolean isSelect() {
		if (selectedCard == null) {
			return false;
		}
		return true;
	}

	//Função usada para comparar a cor da última carta na pilha
	//com a carta a ser adicionada
	public int Color(int a) {
		if (a == 0 || a == 1) {
			return red;
		} else {
			return black;
		}
	}
	
	//Função que verifica se todas as cartas estão presentes
	//no baralho definitivo
	public boolean verificateGame() {
		for (int i = 51; i >= 0; i--) {
			if(diamond == 13 && hearts == 13 && spades == 13 && clubs == 13) {
				return true;
			}
		}
		return false;
	}
	
	//Função para mostrar o texto de fim de jogo
	public void gameOver(boolean p) {
		if(p) {
			Text gameOver = new Text("CONGRATULATIONS");
			gameOver.setFont(Font.font("Verdana", FontWeight.BOLD, 72));
			gameOver.setFill(Color.YELLOW);
			gameOver.setEffect(reflection);
			gameOver.setX(500);
			gameOver.setY(350);
		}
	}

	//Função usada afim de retornar a carta a sua pilha original caso
	//ela não atenda a "cor" ou ao "valor" exigidos
	@SuppressWarnings("static-access")
	public void voltar(int n, ImageView s) {
		switch (n) {
		case 1:
			anchor1.getChildren().add(s);
			anchor1.setTopAnchor(s, y1);
			anchor1.setLeftAnchor(s, x1);
			pilha1.empilha(s);

			y1 += 20;
			retanguloB1.setY(y1 + 150);
			break;
		case 2:
			anchor2.getChildren().add(s);
			anchor2.setTopAnchor(s, y2);
			anchor2.setLeftAnchor(s, x2);
			pilha2.empilha(s);

			y2 += 20;
			retanguloB2.setY(y2 + 150);
			break;
		case 3:
			anchor3.getChildren().add(s);
			anchor3.setTopAnchor(s, y3);
			anchor3.setLeftAnchor(s, x3);
			pilha3.empilha(s);

			y3 += 20;
			retanguloB3.setY(y3 + 150);
			break;
		case 4:
			anchor4.getChildren().add(s);
			anchor4.setTopAnchor(s, y4);
			anchor4.setLeftAnchor(s, x4);
			pilha4.empilha(s);

			y4 += 20;
			retanguloB4.setY(y4 + 150);
			break;
		case 5:
			anchor5.getChildren().add(s);
			anchor5.setTopAnchor(s, y5);
			anchor5.setLeftAnchor(s, x5);
			pilha5.empilha(s);

			y5 += 20;
			retanguloB5.setY(y5 + 150);
			break;
		case 6:
			anchor6.getChildren().add(s);
			anchor6.setTopAnchor(s, y6);
			anchor6.setLeftAnchor(s, x6);
			pilha6.empilha(s);

			y6 += 20;
			retanguloB6.setY(y6 + 150);
			break;
		case 7:
			anchor7.getChildren().add(s);
			anchor7.setTopAnchor(s, y7);
			anchor7.setLeftAnchor(s, x7);
			pilha7.empilha(s);

			y7 += 20;
			retanguloB7.setY(y7 + 150);
			break;
		case 8:
			anchor8.getChildren().add(s);
			anchor8.setTopAnchor(s, y8);
			anchor8.setLeftAnchor(s, x8);
			pilha8.empilha(s);

			y8 += 20;
			retanguloB8.setY(y8 + 150);
			break;
		case 9:
			anchorBL1.getChildren().add(s);
			anchorBL1.setTopAnchor(s, 10.0);
			anchorBL1.setLeftAnchor(s, 50.0);
			break;
		case 10:
			anchorBL2.getChildren().add(s);
			anchorBL2.setTopAnchor(s, 10.0);
			anchorBL2.setLeftAnchor(s, 164.0);
			break;
		case 11:
			anchorBL3.getChildren().add(s);
			anchorBL3.setTopAnchor(s, 10.0);
			anchorBL3.setLeftAnchor(s, 279.0);
			break;
		case 12:
			anchorBL4.getChildren().add(s);
			anchorBL4.setTopAnchor(s, 10.0);
			anchorBL4.setLeftAnchor(s, 393.0);
			break;
		}
	}

	//Função que reseta todos os atributos 
	public void reset() {
		selectedCard = null;
		suit = 0;
		value = 0;
		back = 0;

		retanguloB1.setFill(Color.RED);
		retanguloB2.setFill(Color.RED);
		retanguloB3.setFill(Color.RED);
		retanguloB4.setFill(Color.RED);
		retanguloB5.setFill(Color.RED);
		retanguloB6.setFill(Color.RED);
		retanguloB7.setFill(Color.RED);
		retanguloB8.setFill(Color.RED);
		retanguloBL1.setFill(Color.RED);
		retanguloBL2.setFill(Color.RED);
		retanguloBL3.setFill(Color.RED);
		retanguloBL4.setFill(Color.RED);
		retanguloBR1.setFill(Color.RED);
		retanguloBR2.setFill(Color.RED);
		retanguloBR3.setFill(Color.RED);
		retanguloBR4.setFill(Color.RED);
	}

	//Retangulos uasdos como botões na parte de baixo
	Rectangle retanguloB1 = new Rectangle(widthB, heightB);
	Rectangle retanguloB2 = new Rectangle(widthB, heightB);
	Rectangle retanguloB3 = new Rectangle(widthB, heightB);
	Rectangle retanguloB4 = new Rectangle(widthB, heightB);
	Rectangle retanguloB5 = new Rectangle(widthB, heightB);
	Rectangle retanguloB6 = new Rectangle(widthB, heightB);
	Rectangle retanguloB7 = new Rectangle(widthB, heightB);
	Rectangle retanguloB8 = new Rectangle(widthB, heightB);

	//Retangulos usados como botões nas pilhas intermediárias
	Rectangle retanguloBL1 = new Rectangle(65, heightBL, 60, 20);
	Rectangle retanguloBL2 = new Rectangle(180, heightBL, 60, 20);
	Rectangle retanguloBL3 = new Rectangle(290, heightBL, 60, 20);
	Rectangle retanguloBL4 = new Rectangle(405, heightBL, 60, 20);
	Rectangle retanguloBR1 = new Rectangle(525, heightBL, 60, 20);
	Rectangle retanguloBR2 = new Rectangle(635, heightBL, 60, 20);
	Rectangle retanguloBR3 = new Rectangle(750, heightBL, 60, 20);
	Rectangle retanguloBR4 = new Rectangle(865, heightBL, 60, 20);

	//Função start
	@SuppressWarnings("static-access")
	public void start(Stage palco) throws FileNotFoundException {

		//Implementação das funções
		addSuits();
		adicionar();
		embaralhar();
		empilhar();

		AnchorPane anchor = new AnchorPane();

		//Retangulos usados para formar o visual do jogo
		Rectangle retanguloCentral = new Rectangle(width, height);
		retanguloCentral.setTranslateX(0);
		retanguloCentral.setTranslateY(0);
		retanguloCentral.setFill(Color.DARKGREEN);

		Rectangle retangulo1UL = new Rectangle(widthRect, heightRect);
		retangulo1UL.setStroke(Color.BLACK);
		retangulo1UL.setStrokeWidth(2.0);
		retangulo1UL.setFill(Color.FORESTGREEN);

		Rectangle retangulo2UL = new Rectangle(widthRect, heightRect);
		retangulo2UL.setStroke(Color.BLACK);
		retangulo2UL.setStrokeWidth(2.0);
		retangulo2UL.setFill(Color.FORESTGREEN);

		Rectangle retangulo3UL = new Rectangle(widthRect, heightRect);
		retangulo3UL.setStroke(Color.BLACK);
		retangulo3UL.setStrokeWidth(2.0);
		retangulo3UL.setFill(Color.FORESTGREEN);

		Rectangle retangulo4UL = new Rectangle(widthRect, heightRect);
		retangulo4UL.setStroke(Color.BLACK);
		retangulo4UL.setStrokeWidth(2.0);
		retangulo4UL.setFill(Color.FORESTGREEN);

		Line line = new Line();
		line.setFill(Color.BLACK);
		line.setStartX(495);
		line.setStartY(0);
		line.setEndX(495);
		line.setEndY(170);

		Rectangle retangulo5UR = new Rectangle(widthRect, heightRect);
		retangulo5UR.setStroke(Color.BLACK);
		retangulo5UR.setStrokeWidth(2.0);
		retangulo5UR.setFill(Color.FORESTGREEN);

		Rectangle retangulo6UR = new Rectangle(widthRect, heightRect);
		retangulo6UR.setStroke(Color.BLACK);
		retangulo6UR.setStrokeWidth(2.0);
		retangulo6UR.setFill(Color.FORESTGREEN);

		Rectangle retangulo7UR = new Rectangle(widthRect, heightRect);
		retangulo7UR.setStroke(Color.BLACK);
		retangulo7UR.setStrokeWidth(2.0);
		retangulo7UR.setFill(Color.FORESTGREEN);

		Rectangle retangulo8UR = new Rectangle(widthRect, heightRect);
		retangulo8UR.setStroke(Color.BLACK);
		retangulo8UR.setStrokeWidth(2.0);
		retangulo8UR.setFill(Color.FORESTGREEN);

		Line line2 = new Line();
		line2.setFill(Color.BLACK);
		line2.setStartX(0);
		line2.setStartY(170);
		line2.setEndX(1000);
		line2.setEndY(170);

		//Gerenciador de layout que junta os retangulos correspondentes as pilhas
		HBox hbox = new HBox(20, retangulo1UL, retangulo2UL, retangulo3UL, retangulo4UL, retangulo5UR, retangulo6UR,
				retangulo7UR, retangulo8UR);

		Rectangle retangulo9D = new Rectangle(widthRect, heightRect);
		retangulo9D.setStroke(Color.BLACK);
		retangulo9D.setStrokeWidth(2.0);
		retangulo9D.setFill(Color.FORESTGREEN);

		Rectangle retangulo10D = new Rectangle(widthRect, heightRect);
		retangulo10D.setStroke(Color.BLACK);
		retangulo10D.setStrokeWidth(2.0);
		retangulo10D.setFill(Color.FORESTGREEN);

		Rectangle retangulo11D = new Rectangle(widthRect, heightRect);
		retangulo11D.setStroke(Color.BLACK);
		retangulo11D.setStrokeWidth(2.0);
		retangulo11D.setFill(Color.FORESTGREEN);

		Rectangle retangulo12D = new Rectangle(widthRect, heightRect);
		retangulo12D.setStroke(Color.BLACK);
		retangulo12D.setStrokeWidth(2.0);
		retangulo12D.setFill(Color.FORESTGREEN);

		Rectangle retangulo13D = new Rectangle(widthRect, heightRect);
		retangulo13D.setStroke(Color.BLACK);
		retangulo13D.setStrokeWidth(2.0);
		retangulo13D.setFill(Color.FORESTGREEN);

		Rectangle retangulo14D = new Rectangle(widthRect, heightRect);
		retangulo14D.setStroke(Color.BLACK);
		retangulo14D.setStrokeWidth(2.0);
		retangulo14D.setFill(Color.FORESTGREEN);

		Rectangle retangulo15D = new Rectangle(widthRect, heightRect);
		retangulo15D.setStroke(Color.BLACK);
		retangulo15D.setStrokeWidth(2.0);
		retangulo15D.setFill(Color.FORESTGREEN);

		Rectangle retangulo16D = new Rectangle(widthRect, heightRect);
		retangulo16D.setStroke(Color.BLACK);
		retangulo16D.setStrokeWidth(2.0);
		retangulo16D.setFill(Color.FORESTGREEN);

		HBox hbox2 = new HBox(10, retangulo9D, retangulo10D, retangulo11D, retangulo12D, retangulo13D, retangulo14D,
				retangulo15D, retangulo16D);

		anchor.getChildren().addAll(hbox, hbox2, line, line2);
		anchor.setLeftAnchor(hbox, 50.0);
		anchor.setTopAnchor(hbox, 10.0);
		anchor.setTopAnchor(hbox2, 200.0);
		anchor.setLeftAnchor(hbox2, 70.0);

		//Botões usados no jogo
		retanguloBL1.setStroke(Color.BLACK);
		retanguloBL1.setStrokeWidth(2.0);
		retanguloBL1.setFill(Color.RED);

		retanguloBL2.setStroke(Color.BLACK);
		retanguloBL2.setStrokeWidth(2.0);
		retanguloBL2.setFill(Color.RED);

		retanguloBL3.setStroke(Color.BLACK);
		retanguloBL3.setStrokeWidth(2.0);
		retanguloBL3.setFill(Color.RED);

		retanguloBL4.setStroke(Color.BLACK);
		retanguloBL4.setStrokeWidth(2.0);
		retanguloBL4.setFill(Color.RED);

		retanguloBR1.setStroke(Color.BLACK);
		retanguloBR1.setStrokeWidth(2.0);
		retanguloBR1.setFill(Color.RED);

		retanguloBR2.setStroke(Color.BLACK);
		retanguloBR2.setStrokeWidth(2.0);
		retanguloBR2.setFill(Color.RED);

		retanguloBR3.setStroke(Color.BLACK);
		retanguloBR3.setStrokeWidth(2.0);
		retanguloBR3.setFill(Color.RED);

		retanguloBR4.setStroke(Color.BLACK);
		retanguloBR4.setStrokeWidth(2.0);
		retanguloBR4.setFill(Color.RED);

		//Botões nas pilhas normais
		retanguloB1.setX(x1);
		retanguloB1.setY(y1 + 150);
		retanguloB1.setStroke(Color.BLACK);
		retanguloB1.setStrokeWidth(2.0);
		retanguloB1.setFill(Color.RED);

		retanguloB2.setX(x2);
		retanguloB2.setY(y2 + 150);
		retanguloB2.setStroke(Color.BLACK);
		retanguloB2.setStrokeWidth(2.0);
		retanguloB2.setFill(Color.RED);

		retanguloB3.setX(x3);
		retanguloB3.setY(y3 + 150);
		retanguloB3.setStroke(Color.BLACK);
		retanguloB3.setStrokeWidth(2.0);
		retanguloB3.setFill(Color.RED);

		retanguloB4.setX(x4);
		retanguloB4.setY(y4 + 150);
		retanguloB4.setStroke(Color.BLACK);
		retanguloB4.setStrokeWidth(2.0);
		retanguloB4.setFill(Color.RED);

		retanguloB5.setX(x5);
		retanguloB5.setY(y5 + 150);
		retanguloB5.setStroke(Color.BLACK);
		retanguloB5.setStrokeWidth(2.0);
		retanguloB5.setFill(Color.RED);

		retanguloB6.setX(x6);
		retanguloB6.setY(y6 + 150);
		retanguloB6.setStroke(Color.BLACK);
		retanguloB6.setStrokeWidth(2.0);
		retanguloB6.setFill(Color.RED);

		retanguloB7.setX(x7);
		retanguloB7.setY(y7 + 150);
		retanguloB7.setStroke(Color.BLACK);
		retanguloB7.setStrokeWidth(2.0);
		retanguloB7.setFill(Color.RED);

		retanguloB8.setX(x8);
		retanguloB8.setY(y8 + 150);
		retanguloB8.setStroke(Color.BLACK);
		retanguloB8.setStrokeWidth(2.0);
		retanguloB8.setFill(Color.RED);

		//Setando os eventos de mouse nos botões
		retanguloB1.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			//Se nenhuma carta tiver sido selecionada ele remove da pilha
			//afim de adicionar em outra
			if (!isSelect()) {
				for (int i = 0; i <= 51; i++) {
					if (list.get(i).getContainer().equals(pilha1.espiar())) {
						retanguloB1.setFill(Color.BLUE);
						selectedCard = pilha1.espiar();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 1;
						anchor1.getChildren().remove(anchor1.getChildren().size() - 1);
						pilha1.desempilha();

						y1 -= 20;
						retanguloB1.setY(y1 + 150);

						break;
					}
				}

			//Se alguma carta tiver sido selecionada, ele primeiramente verifica se ela esta vazia,
			//se não, ele verifica se ela atende quanto a "cor" e "valor" exigidos
			} else {
				if(anchor1.getChildren().isEmpty()) {
					pilha1.empilha(selectedCard);
					anchor1.getChildren().add(selectedCard);
					anchor1.setTopAnchor(selectedCard, y1);
					anchor1.setLeftAnchor(selectedCard, x1);

					y1 += 20;
					retanguloB1.setY(y1 + 150);

					reset();
				}else {
				for (int i = 0; i <= 51; i++) {
					if (list.get(i).getContainer().equals(pilha1.espiar())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pilha1.empilha(selectedCard);
								anchor1.getChildren().add(selectedCard);
								anchor1.setTopAnchor(selectedCard, y1);
								anchor1.setLeftAnchor(selectedCard, x1);

								y1 += 20;
								retanguloB1.setY(y1 + 150);

								reset();

								break;
							} else {
								voltar(back, selectedCard);
								reset();

								break;
							}
						} else {
							voltar(back, selectedCard);
							reset();

							break;
						}
					}
				}
			}
			}
		});
		retanguloB2.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 0; i <= 51; i++) {
					if (list.get(i).getContainer().equals(pilha2.espiar())) {
						retanguloB2.setFill(Color.BLUE);
						selectedCard = pilha2.espiar();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 2;
						anchor2.getChildren().remove(anchor2.getChildren().size() - 1);
						pilha2.desempilha();

						y2 -= 20;
						retanguloB2.setY(y2 + 150);

						break;
					}
				}

			} else {
				if(anchor2.getChildren().isEmpty()) {
					pilha2.empilha(selectedCard);
					anchor2.getChildren().add(selectedCard);
					anchor2.setTopAnchor(selectedCard, y2);
					anchor2.setLeftAnchor(selectedCard, x2);

					y2 += 20;
					retanguloB2.setY(y2 + 150);

					reset();
				}else {
				for (int i = 0; i <= 51; i++) {
					if (list.get(i).getContainer().equals(pilha2.espiar())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pilha2.empilha(selectedCard);
								anchor2.getChildren().add(selectedCard);
								anchor2.setTopAnchor(selectedCard, y2);
								anchor2.setLeftAnchor(selectedCard, x2);

								y2 += 20;
								retanguloB2.setY(y2 + 150);

								reset();

								break;
							} else {
								voltar(back, selectedCard);
								reset();

								break;
							}
						} else {
							voltar(back, selectedCard);
							reset();

							break;
						}

					}
				}
				}
			}
		});
		retanguloB3.addEventFilter(MouseEvent.MOUSE_CLICKED, e ->{
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha3.espiar())) {
						retanguloB3.setFill(Color.BLUE);
						selectedCard = pilha3.espiar();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 3;
						anchor3.getChildren().remove(anchor3.getChildren().size() - 1);
						pilha3.desempilha();

						y3 -= 20;
						retanguloB3.setY(y3 + 150);

						break;
					}
				}

			} else {
				if(anchor3.getChildren().isEmpty()) {
					pilha3.empilha(selectedCard);
					anchor3.getChildren().add(selectedCard);
					anchor3.setTopAnchor(selectedCard, y3);
					anchor3.setLeftAnchor(selectedCard, x3);

					y3 += 20;
					retanguloB3.setY(y3 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha3.espiar())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pilha3.empilha(selectedCard);
								anchor3.getChildren().add(selectedCard);
								anchor3.setTopAnchor(selectedCard, y3);
								anchor3.setLeftAnchor(selectedCard, x3);

								y3 += 20;
								retanguloB3.setY(y3 + 150);

								reset();

								break;
							} else {
								voltar(back, selectedCard);
								reset();

								break;
							}
						} else {
							voltar(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		retanguloB4.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha4.espiar())) {
						retanguloB4.setFill(Color.BLUE);
						selectedCard = pilha4.espiar();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 4;
						anchor4.getChildren().remove(anchor4.getChildren().size() - 1);
						pilha4.desempilha();

						y4 -= 20;
						retanguloB4.setY(y4 + 150);

						break;
					}
				}

			} else {
				if(anchor4.getChildren().isEmpty()) {
					pilha4.empilha(selectedCard);
					anchor4.getChildren().add(selectedCard);
					anchor4.setTopAnchor(selectedCard, y4);
					anchor4.setLeftAnchor(selectedCard, x4);

					y4 += 20;
					retanguloB4.setY(y4 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha4.espiar())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pilha4.empilha(selectedCard);
								anchor4.getChildren().add(selectedCard);
								anchor4.setTopAnchor(selectedCard, y4);
								anchor4.setLeftAnchor(selectedCard, x4);

								y4 += 20;
								retanguloB4.setY(y4 + 150);

								reset();

								break;
							} else {
								voltar(back, selectedCard);
								reset();

								break;
							}
						} else {
							voltar(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		retanguloB5.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha5.espiar())) {
						retanguloB5.setFill(Color.BLUE);
						selectedCard = pilha5.espiar();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 5;
						anchor5.getChildren().remove(anchor5.getChildren().size() - 1);
						pilha5.desempilha();

						y5 -= 20;
						retanguloB5.setY(y5 + 150);

						break;
					}
				}

			} else {
				if(anchor5.getChildren().isEmpty()) {
					pilha5.empilha(selectedCard);
					anchor5.getChildren().add(selectedCard);
					anchor5.setTopAnchor(selectedCard, y5);
					anchor5.setLeftAnchor(selectedCard, x5);

					y5 += 20;
					retanguloB5.setY(y5 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha5.espiar())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pilha5.empilha(selectedCard);
								anchor5.getChildren().add(selectedCard);
								anchor5.setTopAnchor(selectedCard, y5);
								anchor5.setLeftAnchor(selectedCard, x5);

								y5 += 20;
								retanguloB5.setY(y5 + 150);

								reset();

								break;
							} else {
								voltar(back, selectedCard);
								reset();

								break;
							}
						} else {
							voltar(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		retanguloB6.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha6.espiar())) {
						retanguloB6.setFill(Color.BLUE);
						selectedCard = pilha6.espiar();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 6;
						anchor6.getChildren().remove(anchor6.getChildren().size() - 1);
						pilha6.desempilha();

						y6 -= 20;
						retanguloB6.setY(y6 + 150);

						break;
					}
				}

			} else {
				if(anchor6.getChildren().isEmpty()) {
					pilha6.empilha(selectedCard);
					anchor6.getChildren().add(selectedCard);
					anchor6.setTopAnchor(selectedCard, y6);
					anchor6.setLeftAnchor(selectedCard, x6);

					y6 += 20;
					retanguloB6.setY(y6 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha6.espiar())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pilha6.empilha(selectedCard);
								anchor6.getChildren().add(selectedCard);
								anchor6.setTopAnchor(selectedCard, y6);
								anchor6.setLeftAnchor(selectedCard, x6);

								y6 += 20;
								retanguloB6.setY(y6 + 150);

								reset();

								break;
							} else {
								voltar(back, selectedCard);
								reset();

								break;
							}
						} else {
							voltar(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		retanguloB7.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha7.espiar())) {
						retanguloB7.setFill(Color.BLUE);
						selectedCard = pilha7.espiar();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 7;
						anchor7.getChildren().remove(anchor7.getChildren().size() - 1);
						pilha7.desempilha();

						y7 -= 20;
						retanguloB7.setY(y7 + 150);

						break;
					}
				}

			} else {
				if(anchor7.getChildren().isEmpty()) {
					pilha7.empilha(selectedCard);
					anchor7.getChildren().add(selectedCard);
					anchor7.setTopAnchor(selectedCard, y7);
					anchor7.setLeftAnchor(selectedCard, x7);

					y7 += 20;
					retanguloB7.setY(y7 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha7.espiar())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pilha7.empilha(selectedCard);
								anchor7.getChildren().add(selectedCard);
								anchor7.setTopAnchor(selectedCard, y7);
								anchor7.setLeftAnchor(selectedCard, x7);

								y7 += 20;
								retanguloB7.setY(y7 + 150);

								reset();

								break;
							} else {
								voltar(back, selectedCard);
								reset();

								break;
							}
						} else {
							voltar(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		retanguloB8.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha8.espiar())) {
						retanguloB8.setFill(Color.BLUE);
						selectedCard = pilha8.espiar();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 8;
						anchor8.getChildren().remove(anchor8.getChildren().size() - 1);
						pilha8.desempilha();

						y8 -= 20;
						retanguloB8.setY(y8 + 150);

						break;
					}
				}

			} else {
				if(anchor8.getChildren().isEmpty()) {
					pilha8.empilha(selectedCard);
					anchor8.getChildren().add(selectedCard);
					anchor8.setTopAnchor(selectedCard, y8);
					anchor8.setLeftAnchor(selectedCard, x8);

					y8 += 20;
					retanguloB8.setY(y8 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pilha8.espiar())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pilha8.empilha(selectedCard);
								anchor8.getChildren().add(selectedCard);
								anchor8.setTopAnchor(selectedCard, y8);
								anchor8.setLeftAnchor(selectedCard, x8);

								y8 += 20;
								retanguloB8.setY(y8 + 150);

								reset();

								break;
							} else {
								voltar(back, selectedCard);
								reset();

								break;
							}
						} else {
							voltar(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});

		//Eventos dos botões das pilhas intermediárias
		//se nenhuma carta estiver selecionada, ele remove da pilha afim de adicionar em outra
		retanguloBL1.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(anchorBL1.getChildren().get(0))) {
						retanguloBL1.setFill(Color.BLUE);
						selectedCard = list.get(i).getContainer();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 9;
						anchorBL1.getChildren().remove(0);

						break;
					}
				}

			//Se não, ele verifica se ela está vazia afim de adicionar na pilha
			} else {
				if (anchorBL1.getChildren().isEmpty()) {
					anchorBL1.getChildren().add(selectedCard);
					anchorBL1.setTopAnchor(selectedCard, 10.0);
					anchorBL1.setLeftAnchor(selectedCard, 50.0);

					reset();
				} else {
					voltar(back, selectedCard);
					reset();

				}
			}
		});
		retanguloBL2.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(anchorBL2.getChildren().get(0))) {
						retanguloBL2.setFill(Color.BLUE);
						selectedCard = list.get(i).getContainer();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 10;
						anchorBL2.getChildren().remove(0);

						break;
					}
				}

			} else {
				if (anchorBL2.getChildren().isEmpty()) {
					anchorBL2.getChildren().add(selectedCard);
					anchorBL2.setTopAnchor(selectedCard, 10.0);
					anchorBL2.setLeftAnchor(selectedCard, 164.0);

					reset();
				} else {
					voltar(back, selectedCard);
					reset();

				}
			}
		});
		retanguloBL3.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(anchorBL3.getChildren().get(0))) {
						retanguloBL3.setFill(Color.BLUE);
						selectedCard = list.get(i).getContainer();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 11;
						anchorBL3.getChildren().remove(0);

						break;
					}
				}

			} else {
				if (anchorBL3.getChildren().isEmpty()) {
					anchorBL3.getChildren().add(selectedCard);
					anchorBL3.setTopAnchor(selectedCard, 10.0);
					anchorBL3.setLeftAnchor(selectedCard, 279.0);

					reset();
				} else {
					voltar(back, selectedCard);
					reset();

				}
			}
		});
		retanguloBL4.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(anchorBL4.getChildren().get(0))) {
						retanguloBL4.setFill(Color.BLUE);
						selectedCard = list.get(i).getContainer();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 12;
						anchorBL4.getChildren().remove(0);

						break;
					}
				}

			} else {
				if (anchorBL4.getChildren().isEmpty()) {
					anchorBL4.getChildren().add(selectedCard);
					anchorBL4.setTopAnchor(selectedCard, 10.0);
					anchorBL4.setLeftAnchor(selectedCard, 393.0);

					reset();
				} else {
					voltar(back, selectedCard);
					reset();

				}
			}
		});

		//Eventos dos botões das pilas definitivas
		retanguloBR1.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (value == diamond) { //Só adiciona na pilha se ele corresponder ao valor
						//da variável "diamond" e ao naipe exigidos
						if (suit == 0) {
							anchorBR1.getChildren().add(selectedCard);
							anchorBR1.setTopAnchor(selectedCard, 10.0);
							anchorBR1.setLeftAnchor(selectedCard, 505.0);
							
							diamond++;
							reset();
							break;
						} else {
							voltar(back, selectedCard);
							reset();

						}
					}else{
						voltar(back, selectedCard);
						reset();
					}
				}
			}
			if(verificateGame()) {
				gameOver(true);
			}
		});

		retanguloBR2.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (value == hearts) {
						if (suit == 1) {
							anchorBR2.getChildren().add(selectedCard);
							anchorBR2.setTopAnchor(selectedCard, 10.0);
							anchorBR2.setLeftAnchor(selectedCard, 620.0);
							
							hearts++;
							reset();
							break;
						} else {
							voltar(back, selectedCard);
							reset();

						}
					}else{
						voltar(back, selectedCard);
						reset();
					}
				}
			}
			if(verificateGame()) {
				gameOver(true);
			}
		});

		retanguloBR3.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (value == spades) {
						if (suit == 2) {
							anchorBR3.getChildren().add(selectedCard);
							anchorBR3.setTopAnchor(selectedCard, 10.0);
							anchorBR3.setLeftAnchor(selectedCard, 733.0);
							
							spades++;
							reset();
							break;
						} else {
							voltar(back, selectedCard);
							reset();

						}
					}else{
						voltar(back, selectedCard);
						reset();
					}
				}
			}
			if(verificateGame()) {
				gameOver(true);
			}
		});

		retanguloBR4.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (value == clubs) {
						if (suit == 3) {
							anchorBR4.getChildren().add(selectedCard);
							anchorBR4.setTopAnchor(selectedCard, 10.0);
							anchorBR4.setLeftAnchor(selectedCard, 848.0);
							
							clubs++;
							reset();
							break;
						} else {
							voltar(back, selectedCard);
							reset();

						}
					}else{
						voltar(back, selectedCard);
						reset();
					}
				}
			}
			if(verificateGame()) {
				gameOver(true);
			}
		});

		//Todos os elementos usados no jogo
		central.getChildren().addAll(retanguloCentral, anchor, anchor1, anchor2, anchor3, anchor4, anchor5, anchor6,
				anchor7, anchor8, retanguloB1, retanguloB2, retanguloB3, retanguloB4, retanguloB5, retanguloB6,
				retanguloB7, retanguloB8, anchorBL1, anchorBL2, anchorBL3, anchorBL4, retanguloBL1, retanguloBL2,
				retanguloBL3, retanguloBL4, retanguloBR1, retanguloBR2, retanguloBR3, retanguloBR4, imageView1,
				imageView2, imageView3, imageView4, anchorBR1, anchorBR2, anchorBR3, anchorBR4);

		Scene cena = new Scene(central, width, height);

		palco.setTitle("Free do Cell");
		palco.setScene(cena);
		palco.show();
	}
}
