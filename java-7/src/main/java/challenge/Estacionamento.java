package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
        if (carrosEstacionados.size() == 10) {
            for (Carro car : carrosEstacionados) {
                if (car.getMotorista().getIdade() <= 55) {
                    carrosEstacionados.remove(car);
                    break;
                }
            }
        }
        if (carrosEstacionados.size() < 10) {
            carrosEstacionados.add(carro);
        }else{
            throw new EstacionamentoException("não há vagas");
        }
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.contains(carro);
    }
}
