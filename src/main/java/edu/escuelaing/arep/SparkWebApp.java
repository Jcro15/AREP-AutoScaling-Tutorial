package edu.escuelaing.arep;

import com.google.gson.Gson;
import edu.escuelaing.arep.math.Fibonacci;

import java.math.BigInteger;

import static spark.Spark.*;

public class SparkWebApp {
    /**
     *  Función encargada de inicializar la aplicación, contiene la implementación de dos endpoints usando el micro
     *  framework Spark, los endpoints mencionados son "Get /" que se encarga de retornar el archivo index.html con la
     *  interfaz gráfica de la aplicación y "Post /calcular" que calcula la media y la desviación estándar a partir
     *  de un conjunto de datos recibido
     * @param args args
     */
    public static void main(String[] args) {
        port(getPort());
        staticFileLocation("/public");

        get("/fibonacci/:number", (req, res) -> {
            return Fibonacci.calculateFibonacci(new BigInteger(req.params(":number")));
        });
    }

    /**
     *
     * @return Retorna el puerto indicado por el entorno, en caso de no encontrarlo retorna el puerto 4567 por defecto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
