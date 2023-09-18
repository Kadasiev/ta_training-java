package com.epam.training.student_david_kadasiev.wrapper_classes;

import java.util.List;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        int shotIndex = ((int)shot.charAt(0) - 65) + ((Integer.parseInt(String.valueOf(shot.charAt(1))) - 1) * 8);
        int leadingZeros = Long.numberOfLeadingZeros(shots);
        char[] shotsField = ("0".repeat(leadingZeros) + (shots == 0 ? "" : Long.toBinaryString(shots))).toCharArray();

        if(shotsField[shotIndex] != '1') {
            shotsField[shotIndex] = '1';

            shots = 0L;
            for(int i = 0; i < 64; i++ ){
                shots = shots | ( Long.parseLong(String.valueOf(shotsField[i])) << i);
            }
            shots = Long.reverse(shots);
        }else{
            return false;
        }

        leadingZeros = Long.numberOfLeadingZeros(ships);
        char[] battleField = ("0".repeat(leadingZeros) + (ships == 0 ? "" : Long.toBinaryString(ships))).toCharArray();
        return battleField[shotIndex] == '1';
    }

    public String state() {
        int leadingZeros = Long.numberOfLeadingZeros(ships);
        String battleField = "0".repeat(leadingZeros) + (ships == 0 ? "" : Long.toBinaryString(ships));
        leadingZeros = Long.numberOfLeadingZeros(shots);
        String shotsField = "0".repeat(leadingZeros) + (ships == 0 ? "" : Long.toBinaryString(shots));
        StringBuilder map = new StringBuilder();

        for(int i = 0; i < battleField.length(); i++) {
            if(i % 8 == 0){
                map.append('\n');
            }

            if (battleField.charAt(i) == '0' && shotsField.charAt(i) == '0') {
                map.append(".");
            } else if (battleField.charAt(i) == '0' && shotsField.charAt(i) == '1') {
                map.append("×");
            } else if (battleField.charAt(i) == '1' && shotsField.charAt(i) == '0') {
                map.append("☐");
            } else if (battleField.charAt(i) == '1' && shotsField.charAt(i) == '1') {
                map.append("☒");
            }
        }
        return map.toString();
    }


    public static void main(String[] args){
        long map = -1150950973573693440L;

        List<String> shots1 = List.of("A1", "B2", "C3", "D4");

        Battleship8x8 battle = new Battleship8x8(map);
        shots1.forEach(battle::shoot);
        System.out.println(battle.state());

    }

}
