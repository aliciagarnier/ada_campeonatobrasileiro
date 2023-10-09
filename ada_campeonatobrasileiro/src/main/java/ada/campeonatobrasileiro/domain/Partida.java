package ada.campeonatobrasileiro.domain;

import java.time.LocalDate;
import java.time.Year;

public class Partida {

 private final String IDPartida;

 private final Year anoPartida;

 private final Time vencedor;

 private final Time timeMandante;

 private final Time timeVisitante;

 private final int placarVisitante;

 private final int placarMandante;

 public Partida(String IDPartida, Year anoPartida, Time vencedor, Time timeMandante, Time timeVisitante, int placarMandante, int placarVisitante)
 {
  this.anoPartida = anoPartida;
  this.IDPartida = IDPartida;
  this.vencedor = vencedor;
  this.timeMandante = timeMandante;
  this.timeVisitante = timeVisitante;
  this.placarVisitante = placarVisitante;
  this.placarMandante = placarMandante;
 }

 public String getIDPartida() {
  return IDPartida;
 }

 public Year getAnoPartida() {
  return anoPartida;
 }

 public Time getVencedor() {
  return vencedor;
 }

 public Time getTimeMandante() {
  return timeMandante;
 }

 public Time getTimeVisitante() {
  return timeVisitante;
 }

 public int getPlacarVisitante() {
  return placarVisitante;
 }

 public int getPlacarMandante() {
  return placarMandante;
 }

 @Override
 public String toString () {
  return  "id: " + IDPartida + " Ano: " + anoPartida + " Vencedor: " + vencedor + " Mandante: " + timeMandante + " Visitante: " + timeVisitante;
 }



}
