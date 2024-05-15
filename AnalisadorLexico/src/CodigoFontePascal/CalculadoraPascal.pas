// equivalente a import unit trabalho; 

{$mode objfpc}{$H+}

interface

uses
  Classes, SysUtils, FileUtil, Forms, Controls, Graphics, Dialogs, StdCtrls,
  ExtCtrls;

type

  { TForm1 }

  TForm1 = class(TForm)
    BtnConversaoDB: TButton; //Botão Decimal > Binário
    BtnConversaoBD: TButton; //Botão inário > Decimal
    BtnSoma: TButton;        //Botão Soma binários
    BtnCalculadora: TButton; //Botão Calculadora Lógica
    BtnVoltar: TButton;
    BtnCalcular: TButton;
    DigitadoDois: TLabel;
    DigitadoUm: TLabel;
    LabelRespostaLogica: TLabel;
    LabelResposta: TLabel;
    RadioAnd: TRadioButton;
    RadioOr: TRadioButton;
    RadioXor: TRadioButton;
    RadioNor: TRadioButton;
    RadioXnor: TRadioButton;
    RadioNand: TRadioButton;
    EscolhaOperacao: TRadioGroup;
    TextoUm: TEdit;
    TextoDois: TEdit;
    LabelSubTitulo: TLabel;
    LabelSubTitulo2: TLabel;
    LabelTitulo: TLabel;
    procedure BtnCalculadoraClick(Sender: TObject);
    procedure BtnCalcularClick(Sender: TObject);
    procedure BtnConversaoDBClick(Sender: TObject);
    procedure BtnConversaoBDClick(Sender: TObject);
    procedure BtnSomaClick(Sender: TObject);
    procedure BtnVoltarClick(Sender: TObject);
  private
    { private declarations }
  public
    { public declarations }
  end;

var
  Form1: TForm1;
  a, i, vetor, valor, dec, valorDec, saidaMenu, seleciona, bits, respostaLogica,
  operacao : integer;
  num, biUm, biDois, recebeNumero, resLogicFinal : string;
  binarioUm, binarioDois, respostaOr, respostaXor, respostaNor, respostaXnor,
  respostaAnd, respostaNand, binario : array[1..8] of integer;

implementation

{$R *.lfm}

{ TForm1 }
procedure limpaVariavel();
 begin
   recebeNumero := '';
   Form1.LabelResposta.Caption := 'Resposta: ' + recebeNumero;
   Form1.LabelResposta.Visible := false;
   i := 0;
   vetor := 0;
   valor := 0;
   dec := 0;
   valorDec := 0;
   saidaMenu := 0;
 end;

procedure someBotoes();
begin
  //Partes que mostram
  Form1.LabelTitulo.Visible := true;
  Form1.LabelSubTitulo.Visible := true;
  Form1.BtnCalcular.Visible := true;
  Form1.BtnVoltar.Visible := true;
  Form1.TextoUm.Visible := true;

  //Partes que escondem
  Form1.BtnConversaoBD.Visible := false;
  Form1.BtnConversaoDB.Visible := false;
  Form1.BtnSoma.Visible := false;
  Form1.BtnCalculadora.Visible := false;

  //Tamanho tela
  Form1.Width := 450;
  Form1.Height := 280;
end;



//Botão Conversão Decimal para Binário
procedure TForm1.BtnConversaoDBClick(Sender: TObject);
begin
  limpaVariavel;
  //Valor que a função do BtnCalcular recebe
  a := 1;

  //Chama função dos botões do menu
  someBotoes;

  //Exibições na tela
  LabelTitulo.Caption := 'Conversão: Decimal > Binário';
  LabelSubTitulo.Caption := 'Digite o numero em decimal entre 0 e 255:';

end;


//Botão Conversão Binário para Decimal
procedure TForm1.BtnConversaoBDClick(Sender: TObject);
begin
  limpaVariavel;
  //Valor que a função do BtnCalcular recebe
  a := 2;

  //Chama função dos botões do menu
  someBotoes;

  //Exibições na tela
  LabelTitulo.Caption := 'Conversão: Binário > Decimal';
  LabelSubTitulo.Caption := 'Digite o numero em binario:';
end;

//Botão Soma de Binários
procedure TForm1.BtnSomaClick(Sender: TObject);
begin
  limpaVariavel;
  //Valor que a função do BtnCalcular recebe
  a := 3;

  //Chama função dos botões do menu
  someBotoes;

  //Exibições na tela
  LabelTitulo.Caption := 'Soma de Binários';
  LabelSubTitulo.Caption := 'Digite o primeiro binario:';
  LabelSubTitulo2.Caption := 'Digite o segundo binario:';
  TextoDois.Visible := true;
  LabelSubTitulo2.Visible := true;

end;

//Botão Calculadora Lógica
procedure TForm1.BtnCalculadoraClick(Sender: TObject);
begin
  limpaVariavel;
  //Valor que a função do BtnCalcular recebe
  a := 4;

  //Chama função dos botões do menu
  someBotoes;

  //Exibições na tela
  LabelTitulo.Caption := 'Calculadora Lógica';
  LabelSubTitulo.Caption := 'Digite o primeiro binario:';
  LabelSubTitulo2.Caption := 'Digite o segundo binario:';
  TextoDois.Visible := true;
  LabelSubTitulo2.Visible := true;
  Form1.EscolhaOperacao.Visible := true;
end;

//Botão Calcular
procedure TForm1.BtnCalcularClick(Sender: TObject);
begin
  limpaVariavel;
  //Decimal para Binários
  if (a = 1) then
  begin
       {------CONVERSÃO DE DECIMAL PARA BINÁRIO------}
       valorDec := 128;

       dec := StrToInt(TextoUm.Text);
       for i:=1 to 8 do
       begin
            //*Comentário: Guarda o valor 0 e 1 em uma lista de até 8 posições*

            binario[i] := dec div valorDec;

            //*Comentário: Depois de guardar o valor, ele pega e guarda o resto em dec*

            dec := dec mod valorDec;

            {*Comentário: Pega o valor do bit divide por 2. Por exemplo:
            o primeiro bit se for contar da esquerda para a
            direita é o 128, logo divide por 2 e temos o
            segundo bit 64 e assim sucessivamente.*}

            valorDec := valorDec div 2;

            //*Comentário: Escreve o binário*
            recebeNumero := recebeNumero + IntToStr(binario[i]);
       end;
       LabelResposta.Caption := 'Resposta: ' + recebeNumero;
       LabelResposta.Visible := true;
       TextoUm.Clear;
  end;

  //Binários para Decimal
  if (a = 2) then
  begin
       {------CONVERSÃO DE BINÁRIO PARA DECIMAL------}
       {*Comentário: valor = casa binária;
       num = número que o usuário digitou;*}
       valor := 1;
       num := TextoUm.Text;

       {*Comentário: Faz um loop ao contrário, ou seja, de 8 até 1. Fazendo isso
       ele "printa" na tela as casas binárias na ordem correta.
       Além disso ele vai andando casa por casa da string num, converte
       para inteiro e multiplica pelo valor.*}
       for i:=8 downto 1 do
       begin
            vetor := vetor + (StrToInt(num[i]) * valor);
            valor := valor * 2;
       end;
       LabelResposta.Caption := 'Em decimal é: ' + IntToStr(vetor);
       LabelResposta.Visible := true;
       TextoUm.Clear;
  end;

  //Soma de Binários
  if (a = 3) then
  begin
       {------SOMA DE BINÁRIOS------}
       {*Comentário: valor = casa binária;
       num = número que o usuário digitou;*}
       valor := 1;
       num := TextoUm.Text;
       {*Comentário: Faz um loop ao contrário, ou seja, de 8 até 1. Fazendo isso
       ele "printa" na tela as casas binárias na ordem correta.
       Além disso ele vai andando casa por casa da string num, converte
       para inteiro e multiplica pelo valor.*}

       for i:=8 downto 1 do
       begin
            vetor := vetor + (StrToInt(num[i]) * valor);
            valor := valor * 2;
       end;

       valor := 1;
       num := TextoDois.Text;
       {*Comentário: Faz um loop ao contrário, ou seja, de 8 até 1. Fazendo isso
       ele "printa" na tela as casas binárias na ordem correta.
       Além disso ele vai andando casa por casa da string num, converte
       para inteiro e multiplica pelo valor.*}
       for i:=8 downto 1 do
       begin
            vetor := vetor + (StrToInt(num[i]) * valor);
            valor := valor * 2;
       end;

       //*Comentário: Verifica quantas casas tem no binário.
       if (vetor > 255) then
       begin
           bits := 9;
           valorDec := 256;
       end;
       if (vetor <= 255) then
       begin
           bits := 8;
           valorDec := 128;
       end;
       {*Comentário: Os dois binários digitados pelo usuário já foram digitados
       e transformados em apenas um decimal, ou seja, foi feita a soma dos dois.
       Essa parte do código é responsável por pegar esse decimal e transformar
       em binários novamente.*}
       for i:=1 to bits do
       begin
            //*Comentário: Guarda o valor 0 e 1 em uma lista de até 8 posições*

            binario[i] := vetor div valorDec;

            //*Comentário: Depois de guardar o valor, ele pega e guarda a soma em vetor*

            vetor := vetor mod valorDec;

            {*Comentário: Pega o valor do bit divide por 2. Por exemplo:
            o primeiro bit se for contar da esquerda para a
            direita é o valor guardado em ValorDec, logo divide por 2 e temos o
            segundo bit que seria ValorDec/2 e assim sucessivamente.*}

            valorDec := valorDec div 2;

            //*Comentário: Escreve o binário*
            recebeNumero := recebeNumero + IntToStr(binario[i]);
       end;
       LabelResposta.Caption := 'A soma é: ' + recebeNumero;
       LabelResposta.Visible := true;
       TextoUm.Clear;
       TextoDois.Clear;
  end;

  //Calculadora Lógica
  if (a = 4) then
  begin

       {------CALCULADORA LÓGICA------}
       //*Comentário: Pega os dois binarios de 8 bits*
        biUm := TextoUm.Text;

        biDois := TextoDois.Text;

        for i:=8 downto 1 do
        begin
             {*Comentário: Transforma dos dois binários de string
             para inteiro.*}
             binarioUm[i] :=  StrToInt(biUm[i]);
             binarioDois[i] :=  StrToInt(biDois[i]);


             {*Comentário: Faz a comparação lógica e vai guardando em cada array.
             Por exemplo: o array da operação lógica OR é respostaOr[i]. Cada array
             tem podem guardar até 8 números.*}
             if (binarioUm[i] = 1) and (binarioDois[i] = 1) then
             begin
                 respostaOr[i] := 1;
                 respostaXor[i] := 0;
                 respostaNor[i] := 0;
                 respostaXnor[i] := 1;
                 respostaAnd[i] := 1;
                 respostaNand[i] := 0;
             end;
             if (binarioUm[i] = 0) and (binarioDois[i] = 0) then
             begin
                 respostaOr[i] := 0;
                 respostaXor[i] := 0;
                 respostaNor[i] := 1;
                 respostaXnor[i] := 1;
                 respostaAnd[i] := 0;
                 respostaNand[i] := 1;
             end;
             if (binarioUm[i] = 1) and (binarioDois[i] = 0) then
             begin
                 respostaOr[i] := 1;
                 respostaXor[i] := 1;
                 respostaNor[i] := 0;
                 respostaXnor[i] := 0;
                 respostaAnd[i] := 0;
                 respostaNand[i] := 1;
             end;
             if (binarioUm[i] = 0) and (binarioDois[i] = 1) then
             begin
                 respostaOr[i] := 1;
                 respostaXor[i] := 1;
                 respostaNor[i] := 0;
                 respostaXnor[i] := 0;
                 respostaAnd[i] := 0;
                 respostaNand[i] := 1;
             end;
        end;

        {*Comentário: Aqui ele mostra o que foi digitado pelo usuário
        para o binário 1*}
        for i:=1 to 8 do
        begin
             recebeNumero := recebeNumero + IntToStr(binarioUm[i]);
        end;
        Form1.DigitadoUm.Visible := true;
        DigitadoDois.Caption := 'Binário 1: ' + recebeNumero;
        recebeNumero := '';

        Form1.LabelResposta.Caption := 'Resposta: ' + recebeNumero;
        Form1.LabelResposta.Visible := false;
        {*Comentário: Aqui ele mostra o que foi digitado pelo usuário
        para o binário 2*}
        for i:=1 to 8 do
        begin
             recebeNumero := recebeNumero + IntToStr(binarioDois[i]);
        end;
        Form1.DigitadoDois.Visible := true;
        DigitadoUm.Caption := 'Binário 2: ' + recebeNumero;
        recebeNumero := '';

        if RadioAnd.Checked then
        begin
           operacao := 1;
        end;
        if RadioOr.Checked then
        begin
           operacao := 2;
        end;
        if RadioXor.Checked then
        begin
           operacao := 3;
        end;
        if RadioNor.Checked then
        begin
           operacao := 4;
        end;
        if RadioXnor.Checked then
        begin
           operacao := 5;
        end;
        if RadioNand.Checked then
        begin
           operacao := 6;
        end;


       {*Comentário: Mostra o resultado da operação lógica e
       a escreve na tela.*}
       Case operacao of
            1: begin
                    //AND
                    for i:=1 to 8 do
                    begin
                         recebeNumero := recebeNumero + IntToStr(respostaAnd[i]);
                         respostaLogica := respostaLogica + respostaAnd[i];
                    end;
               end;

            2: begin
                    //OR
                    for i:=1 to 8 do
                    begin
                         recebeNumero := recebeNumero + IntToStr(respostaOr[i]);
                         respostaLogica := respostaLogica + respostaOr[i];
                    end;
               end;

            3: begin
                    //XOR
                    for i:=1 to 8 do
                    begin
                         recebeNumero := recebeNumero + IntToStr(respostaXor[i]);
                         respostaLogica := respostaLogica + respostaXor[i];
                    end;
               end;

            4: begin
                    //NOR
                    for i:=1 to 8 do
                    begin
                         recebeNumero := recebeNumero + IntToStr(respostaNor[i]);
                         respostaLogica := respostaLogica + respostaNor[i];
                    end;
               end;

            5: begin
                    //XNOR
                    for i:=1 to 8 do
                    begin
                         recebeNumero := recebeNumero + IntToStr(respostaXnor[i]);
                         respostaLogica := respostaLogica + respostaXnor[i];
                    end;
               end;

            6: begin
                    //NAND
                    for i:=1 to 8 do
                    begin
                         LabelTitulo.Caption := 'Escolheu NAND';
                         recebeNumero := recebeNumero + IntToStr(respostaNand[i]);
                         respostaLogica := respostaLogica + respostaNand[i];
                    end;
               end;

        end;
        LabelResposta.Caption := 'Resposta: ' + recebeNumero;
        if respostaLogica = 8 then
        begin
             resLogicFinal := '(Tautologia)';
        end;
        if respostaLogica = 0 then
        begin
             resLogicFinal := '(Contradição)';
        end;
        if (respostaLogica > 0) and (respostaLogica < 8) then
        begin
             resLogicFinal := '(Contigência)';
        end;

        LabelRespostaLogica.Caption := resLogicFinal;
        LabelResposta.Visible := true;
        TextoUm.Clear;
        TextoDois.Clear;
  end;

end;

//Botão Voltar
procedure TForm1.BtnVoltarClick(Sender: TObject);
begin
  a := 0;
  //Partes que mostram
  BtnConversaoBD.Visible := true;
  BtnConversaoDB.Visible := true;
  BtnSoma.Visible := true;
  BtnCalculadora.Visible := true;

  //Parte que escondem
  LabelSubTitulo.Visible := false;
  LabelSubTitulo2.Visible := false;
  LabelTitulo.Visible := false;
  BtnCalcular.Visible := false;
  Form1.TextoUm.Visible := false;
  Form1.TextoDois.Visible := false;
  Form1.DigitadoUm.Visible := false;
  Form1.DigitadoDois.Visible := false;
  Form1.EscolhaOperacao.Visible := false;

  //Tamanho da tela
  Form1.Width := 270;
  Form1.Height := 170;
end;
end.
