<?php
class Pill
{
    public function __construct($tn, $n, $f, $p)
    {
        $this->tradeName = $tn;
        $this->name = $n;
        $this->formula = $f;
        $this->price = $p;
    }
    function getTradeName() {
        return $this->tradeName;
    }
    function getName() {
        return $this->Name;
    }
    function getFormula() {
        return $this->Formula;
    }
    function getPrice() {
        return $this->price;
    }
    function showBottle() {
        echo "<img src=\"img/$this->TradeName.jpg\">";
    }
}
?>
