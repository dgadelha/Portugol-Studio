package br.univali.ps.ui.swing;

import br.univali.ps.nucleo.Configuracoes;
import br.univali.ps.ui.utils.IconFactory;
import java.awt.Color;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author LITE
 */
public final class ColorController {
    
    private static JSONObject getTemaSelecionado()
    {
        JSONObject json = Configuracoes.getInstancia().getArquivo_temas();
        
        if(json == null)
        {
            json = getTemaPadrao();
        }
        
        JSONObject json_temas = json.getJSONObject("temas");
        
        String tema_selecionado = json.getString("tema_selecionado"); 
        return json_temas.getJSONObject(tema_selecionado);
    }
       
    private static JSONObject getTemaEditor()
    {    
        Configuracoes.getInstancia().setIconesCores(TEMA_SELECIONADO.getString("icones"));
        IconFactory.verificarTema();
        
        return TEMA_SELECIONADO.getJSONObject("Editor");
    }
    
    private static Color[] getTema()
    {        
        Configuracoes.getInstancia().setIconesCores(TEMA_SELECIONADO.getString("icones"));
        IconFactory.verificarTema();
                
        return new Color[]{
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("cor_letra"), 16)),
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("cor_destaque"), 16)),
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("cor_principal"), 16)),
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("fundo_escuro"), 16)),
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("fundo_medio"), 16)),
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("fundo_claro"), 16)),
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("progress_bar"), 16)),
                new Color(255,194,0),   //amarelo
                new Color(69,189,255),  //azul claro
                new Color(240,67,59),   //vermelho
                new Color(0,239,192),   //ciano
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("fundo_botoes_expansiveis"), 16)),    //cinza azulado muito mais escuro
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("cor_letra_titulo"), 16)), //cinza claro
                new Color(Integer.parseInt(TEMA_SELECIONADO.getString("cor_console"), 16)),    //cinza azulado
                new Color(0,0,0,0)      //Transparente
            };     
    }
    
    public static String[] listarTemas()
    {
        JSONObject json = Configuracoes.getInstancia().getArquivo_temas();
        
        if(json == null)
        {
            json = getTemaPadrao();
        }
        
        JSONObject json_temas = json.getJSONObject("temas");
        
        return JSONObject.getNames(json_temas);
    }
    
    private static JSONObject getTemaPadrao()
    {
        String defaultThemeFile = 
        "{\n" +
"	\"tema_selecionado\" : \"Dark\",	\n" +
"	\"temas\" : \n" +
"	{\n" +
"		\"Dark\" : \n" +
"		{\n" +
"			\"cor_letra\" : \"cdcdcd\",\n" +
"			\"cor_destaque\" : \"3a464c\",\n" +
"			\"cor_principal\" : \"263238\",\n" +
"			\"fundo_escuro\" : \"121e24\",\n" +
"			\"fundo_medio\" : \"263238\",\n" +
"			\"fundo_claro\" : \"445056\",\n" +
"			\"progress_bar\" : \"f1433c\",\n" +
"			\"fundo_botoes_expansiveis\" : \"121e24\",\n" +
"			\"cor_letra_titulo\" : \"cdcdcd\",\n" +
"			\"cor_console\" : \"3a464c\",\n" +
"			\"icones\" : \"Claros\",\n" +
"			\n" +
"			\"Editor\" : \n" +
"			{\n" +
"				\"background_editor\" : \"263238\",\n" +
"				\"cursor\" : \"c1cbc2\",\n" +
"				\"selection_bg\" : \"404E51\",\n" +
"				\"selecao_linha_atual\" : \"2F393C\",\n" +
"				\"selecao_chave_correspondente_fg\" : \"6A8088\",\n" +
"				\"selecao_chave_correspondente_bg\" : \"6b8189\",\n" +
"				\"borda_barra_lateral\" : \"1E2324\",\n" +
"				\"numeros_das_linhas\" : \"516268\",\n" +
"				\"dobrador_de_codigo\" : \"516268\",\n" +
"				\"identificador\" : \"FBFBFB\",\n" +
"				\"palavras_reservadas\" : \"F1433C\",\n" +
"				\"comentario_linha\" : \"66747B\",\n" +
"				\"comentario_multilinha\" : \"66747B\",\n" +
"				\"chamada_funcao\" : \"FBFBFB\",\n" +
"				\"tipos\" : \"45BEFF\",\n" +
"				\"valor_logico\" : \"F1433C\",\n" +
"				\"valor_inteiro\" : \"00F0C0\",\n" +
"				\"valor_real\" : \"00F0C0\",\n" +
"				\"valor_hexa\" : \"00F0C0\",\n" +
"				\"valor_cadeia\" : \"FFC200\",\n" +
"				\"valor_caracter\" : \"FFC200\",\n" +
"				\"operador\" : \"E8E2B7\",\n" +
"				\"separador\" : \"E8E2B7\",\n" +
"				\"erro_fg\" : \"FBFBFB\",\n" +
"				\"erro_bg\" : \"04790e\"\n" +
"			}\n" +
"		},		\n" +
"		\"Portugol\" : \n" +
"		{\n" +
"			\"cor_letra\" : \"333333\",\n" +
"			\"cor_destaque\" : \"d2e7fc\",\n" +
"			\"cor_principal\" : \"fafafa\",\n" +
"			\"fundo_escuro\" : \"316892\",\n" +
"			\"fundo_medio\" : \"c1d9f5\",\n" +
"			\"fundo_claro\" : \"e4f1fe\",\n" +
"			\"progress_bar\" : \"ffc200\",\n" +
"			\"fundo_botoes_expansiveis\" : \"ffffff\",\n" +
"			\"cor_letra_titulo\" : \"ffffff\",\n" +
"			\"cor_console\" : \"e6e6e6\",\n" +
"			\"icones\" : \"Escuros\",\n" +
"			\n" +
"			\"Editor\" : \n" +
"			{\n" +
"				\"background_editor\" : \"fafafa\",\n" +
"				\"cursor\" : \"ff0000\",\n" +
"				\"selection_bg\" : \"404E51\",\n" +
"				\"selecao_linha_atual\" : \"2F393C\",\n" +
"				\"selecao_chave_correspondente_fg\" : \"000080\",\n" +
"				\"selecao_chave_correspondente_bg\" : \"eaeaff\",\n" +
"				\"borda_barra_lateral\" : \"dddddd\",\n" +
"				\"numeros_das_linhas\" : \"787878\",\n" +
"				\"dobrador_de_codigo\" : \"808080\",\n" +
"				\"identificador\" : \"000000\",\n" +
"				\"palavras_reservadas\" : \"0000ff\",\n" +
"				\"comentario_linha\" : \"808080\",\n" +
"				\"comentario_multilinha\" : \"808080\",\n" +
"				\"chamada_funcao\" : \"ad8000\",\n" +
"				\"tipos\" : \"008080\",\n" +
"				\"valor_logico\" : \"0000ff\",\n" +
"				\"valor_inteiro\" : \"6400C8\",\n" +
"				\"valor_real\" : \"6400C8\",\n" +
"				\"valor_hexa\" : \"6400C8\",\n" +
"				\"valor_cadeia\" : \"DC009C\",\n" +
"				\"valor_caracter\" : \"DC009C\",\n" +
"				\"operador\" : \"804040\",\n" +
"				\"separador\" : \"ff0000\",\n" +
"				\"erro_fg\" : \"000000\",\n" +
"				\"erro_bg\" : \"ffcccc\"\n" +
"			}\n" +
"		}\n" +
"	}	\n" +
"}";
        
        return new JSONObject(defaultThemeFile);
    }
    
    private static final JSONObject TEMA_SELECIONADO = getTemaSelecionado();
    public static final JSONObject TEMA_EDITOR = getTemaEditor();    
    
    private static final Color[] THEME= getTema();
    public static final Color COR_LETRA = THEME[0];
    public static final Color COR_DESTAQUE = THEME[1];
    public static final Color COR_PRINCIPAL = THEME[2];
    public static final Color FUNDO_ESCURO = THEME[3];
    public static final Color FUNDO_MEDIO = THEME[4];
    public static final Color FUNDO_CLARO = THEME[5];
    public static final Color PROGRESS_BAR = THEME[6];
    public static final Color AMARELO = THEME[7];
    public static final Color AZUL = THEME[8];
    public static final Color VERMELHO = THEME[9];
    public static final Color VERDE = THEME[10];
    public static final Color FUNDO_BOTOES_EXPANSIVEIS = THEME[11];
    public static final Color COR_LETRA_TITULO = THEME[12];
    public static final Color COR_CONSOLE = THEME[13];
    public static final Color TRANSPARENTE = THEME[14];    
}
