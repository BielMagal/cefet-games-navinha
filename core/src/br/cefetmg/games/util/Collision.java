package br.cefetmg.games.util;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import static java.lang.Math.pow;

/**
 * Utilitário para verificação de colisão.
 *
 * @author fegemo <coutinho@decom.cefetmg.br>
 */
public class Collision {

    /**
     * Verifica se dois círculos em 2D estão colidindo.
     * @param c1 círculo 1
     * @param c2 círculo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean circlesOverlap(Circle c1, Circle c2) {
        double d_quad = pow(c1.x-c2.x,2) + pow(c1.y-c2.y,2);
        if(pow(c1.radius+c2.radius,2)>d_quad)
            return true;
        return false;
    }

    /**
     * Verifica se dois intervalos em 1D estão colidindo.
     * @param pos1 valor mais à esquerda do intervalo 1
     * @param tam1 valor do tamanho do intervalo 1
     * @param pos2 valor mais à esquerda do intervalo 2
     * @param tam2 valor do tamanho do intervalo 2
     * @return true se há colisão ou false, do contrário.
     * Funcionalidade: Verifica qual retangulo está mais a esquerda e testa se a ponta mais a esquerda do outro está dentro dele.
     */
    private static boolean rangesIntersect(
            float pos1, float tam1,
            float pos2, float tam2) {
        if(pos1>pos2){
            if(pos2+tam2>=pos1)
                return true;
        }else if(pos1+tam1>=pos2)
                return true;
        return false;
    }

    /**
     * Verifica se dois retângulos em 2D estão colidindo.
     * Esta função pode verificar se o eixo X dos dois objetos está colidindo
     * e então se o mesmo ocorre com o eixo Y.
     * @param r1 retângulo 1
     * @param r2 retângulo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean rectsOverlap(Rectangle r1, Rectangle r2) {
        return rangesIntersect(r1.x,r1.width,r2.x,r2.width)&&rangesIntersect(r1.y,r1.height,r2.y,r2.height);
    }

}
