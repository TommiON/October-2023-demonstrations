package com.example.populationinfosystem.utilities;

public enum PersonIdentifierCheckCharacter {
    _0('0'),
    _1('1'),
    _2('2'),
    _3('3'),
    _4('4'),
    _5('5'),
    _6('6'),
    _7('7'),
    _8('8'),
    _9('9'),
    _10('A'),
    _11('B'),
    _12('C'),
    _13('D'),
    _14('E'),
    _15('F'),
    _16('H'),
    _17('J'),
    _18('K'),
    _19('L'),
    _20('M'),
    _21('N'),
    _22('P'),
    _23('R'),
    _24('S'),
    _25('T'),
    _26('U'),
    _27('V'),
    _28('W'),
    _29('X'),
    _30('Y');

    private final Character check;

    private PersonIdentifierCheckCharacter(Character check) {
        this.check = check;
    }

    public Character getCheck() {
        return this.check;
    }
}
