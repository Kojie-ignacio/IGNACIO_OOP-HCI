
function computeResults(e) {
    // UI

    const UILoan = document.getElementById("loanA").value;
    const UIRate = document.getElementById("interestR").value;
    const UIYrs = document.getElementById("yrs").value;

    // Calculate

    const principal = parseFloat(UILoan);
    const CalcInterest = parseFloat(UIRate) / 100 / 12;
    const CalcPayments = parseFloat(UIYrs) * 12;

    //Compute monthly Payment

    const x = Math.pow(1 + CalcInterest, CalcPayments);
    const mon = (principal * x * CalcInterest) / (x - 1);
    const monPayment = mon.toFixed(2);

    //Compute Interest

    const totalInt = (mon * CalcPayments - principal).toFixed(2);

    //Compute Total Payment

    const totalPay = (mon * CalcPayments).toFixed(2);

    //Show results

    document.getElementById("monPayment").innerHTML = "$" + monPayment;

    document.getElementById("totalInt").innerHTML = "%" + totalInt;

    document.getElementById("totalPay").innerHTML = "$" + totalPay;

    e.preventDefault();
}