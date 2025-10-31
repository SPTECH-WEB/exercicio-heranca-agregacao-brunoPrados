package school.sptech;
import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size() < vagas ) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack() == true){
            desenvolvedores.add(desenvolvedor);
        }
    }
    public Double getTotalSalarios(){
        Double soma = 0.0;
        for (Desenvolvedor d : desenvolvedores) {
            soma += d.calcularSalario();
        }
        return soma;
    }
    public Integer qtdDesenvolvedoresMobile(){
        Integer contador = 0;
        for (Desenvolvedor d : desenvolvedores) {
            if (d instanceof DesenvolvedorMobile) {
                contador++;
            }
        }
        return contador;
    }
    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedoresSalario = new ArrayList<>();
        for (Desenvolvedor d : desenvolvedores) {
            if (d.calcularSalario() >= salario) {
                desenvolvedoresSalario.add(d);
            }
        }
        return desenvolvedoresSalario;
    }
    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor menorSalario = desenvolvedores.get(0);
        for (Desenvolvedor d : desenvolvedores) {
            if (d.calcularSalario() < menorSalario.calcularSalario()) {
                menorSalario = d;
            }
        }
        return menorSalario;
    }


    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor d : desenvolvedores) {
            if (d instanceof DesenvolvedorWeb web) {
                if (tecnologia.equalsIgnoreCase(web.getBackend()) ||
                        tecnologia.equalsIgnoreCase(web.getFrontend()) ||
                        tecnologia.equalsIgnoreCase(web.getSgbd())) {
                    resultado.add(web);
                }
            } else if (d instanceof DesenvolvedorMobile mob) {
                if (tecnologia.equalsIgnoreCase(mob.getPlataforma()) ||
                        tecnologia.equalsIgnoreCase(mob.getLinguagem())) {
                    resultado.add(mob);
                }
            }
        }
        return resultado;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        double total = 0.0;
        for (Desenvolvedor d : buscarPorTecnologia(tecnologia)) {
            total += d.calcularSalario();
        }
        return total;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
