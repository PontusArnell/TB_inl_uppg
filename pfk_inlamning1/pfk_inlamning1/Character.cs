using System;

namespace pfk_inlamning1 { 
     class Character 
    {

        private string name;
        private int strength;
        private int luck;
        private int health;

        public Character(string name) {
            this.name = name;
            Random rnd = new Random();
            
            strength = rnd.Next(1, 100);
            luck = rnd.Next(1, 100);
            health= rnd.Next(1, 100);
        }

        public string getName() { return name; }

        public int getStrength() { return strength; }

        public int getLuck() { return luck; }

        public int getHealth() { return health; }

        public string toString() { return name + " health: " + getHealth() + " luck: " + getLuck() + " strength: " + getStrength(); }

    }
}

