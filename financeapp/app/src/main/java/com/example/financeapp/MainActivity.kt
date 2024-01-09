package com.example.financeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financeapp.ui.theme.FinanceappTheme
import kotlin.system.exitProcess


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    financeapp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun financeapp() {
    Scaffold(
        topBar = {
            financeTopAppBar()
        }
    ) {  it -> financeapplayout()

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun financeTopAppBar(modifier: Modifier = Modifier) {
    Surface {
        CenterAlignedTopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .padding(),
                        painter = painterResource(R.drawable.financeappscaffold),


                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    Text(
                        text = "FinanceApp",
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            },
            modifier = modifier
        )
    }
}


@Composable
fun financeapplayout(modifier: Modifier = Modifier) {
    var page by remember { mutableIntStateOf(0) }
    var paymentamount by remember { mutableStateOf("0") }
    var walletbalance by remember { mutableIntStateOf(0) }
    var addbalance by remember { mutableStateOf("0") }
    var nobalanceone by remember { mutableStateOf("") }
    var nobalancetwo by remember { mutableStateOf("") }
    var nobalancethree by remember { mutableStateOf("") }
    var bankbalance by remember { mutableIntStateOf(0) }
    var loanvalue by remember { mutableStateOf("0") }
    var statement by remember { mutableStateOf("") }
    var i by remember { mutableStateOf(3) }
    var roundUp by remember { mutableStateOf(false) }
    var rewardtext by remember { mutableStateOf("")  }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp)
            .wrapContentSize(align = Alignment.BottomCenter),
        horizontalAlignment = Alignment.CenterHorizontally



    ) {
        FloatingActionButton(onClick = { page = 0 }) {

            Text(text = "🏠")

        }
    }




    when(page){
        0 -> {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.graph),
                    contentDescription = "Stocks picture",
                    modifier = Modifier
                        .wrapContentSize()
                        .align(alignment = Alignment.Start),
                    contentScale = ContentScale.FillWidth

                )
                Text(text = "Invest in Stocks ⬆️")



                Surface(
                    color = Color.Yellow,
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp, top = 20.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .wrapContentSize()
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),

                        ) {


                        //PAGE 1 ****************
                        Column(
                            modifier = Modifier
                                .padding(top = 10.dp, start = 6.dp)
                                .clickable { page = 1 },

                            ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(8.dp)),

                                ) {
                                Image(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    painter = painterResource(R.drawable.bank),
                                    contentDescription = null,
                                    alignment = Alignment.CenterStart,
                                    contentScale = ContentScale.FillWidth
                                )

                            }
                            //Text(text = "Your", modifier = Modifier.padding(start = 6.dp))
                            Text(text = "Bank", modifier = Modifier.padding(start = 6.dp))
                        }


                        //PAGE 2 ****************
                        Column(
                            modifier = Modifier
                                .padding(top = 10.dp, start = 35.dp)
                                .clickable { page = 2 },
                            horizontalAlignment = Alignment.Start
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(8.dp)),

                                ) {
                                Image(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    painter = painterResource(R.drawable.pay),
                                    contentDescription = null,
                                    alignment = Alignment.CenterStart,
                                    contentScale = ContentScale.FillWidth
                                )

                            }
                            Text(
                                text = "Pay",
                                modifier = Modifier.padding(start = 12.dp),

                                )
                        }


                        //PAGE 3 ****************
                        Column(
                            modifier = Modifier
                                .padding(top = 10.dp, start = 45.dp, end = 5.dp)
                                .clickable { page = 3 },

                            ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(8.dp)),

                                ) {
                                Image(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    painter = painterResource(R.drawable.wallet),
                                    contentDescription = null,
                                    alignment = Alignment.CenterStart,
                                    contentScale = ContentScale.FillWidth
                                )

                            }
                            Text(
                                text = "Wallet",
                                modifier = Modifier.padding(start = 2.dp)
                            )

                        }

                        //PAGE 4 ****************
                        Column(
                            modifier = Modifier
                                .padding(top = 10.dp, start = 30.dp)
                                .clickable { page = 4 },

                            ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(8.dp)),

                                ) {
                                Image(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    painter = painterResource(R.drawable.getloan),
                                    contentDescription = null,
                                    alignment = Alignment.CenterStart,
                                    contentScale = ContentScale.FillWidth
                                )

                            }

                            Text(text = "Loan", modifier = Modifier.padding(start = 5.dp))
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp)
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Button(onClick = { page = 5 }) {
                        Text(
                            text = "Earn Rewards",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                }
            }
        }

        1-> {
            Column(
                modifier = Modifier.padding(top = 150.dp, start = 20.dp)
            ) {
                Text(
                    text = "Your Bank",
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Your Balance: Rs. $bankbalance",

                    )

                Spacer(modifier = Modifier.height(30.dp))

                Text(text = "Do you want a loan?")

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 150.dp)
                ) {
                    Button(onClick = { page = 4 },
                        enabled = if (bankbalance <= 1000 ) {
                            true
                        }
                        else{
                            false
                        }
                    ) {
                        Text(text = "Get Loan")
                    }
                }
            }
        }

        2 -> {

            paymentmethod(roundUp = roundUp) { roundUp = it }

            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(start = 40.dp, end = 40.dp, top = 200.dp)
                    .safeDrawingPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = "Payment: ",
                    modifier = Modifier
                        .padding(bottom = 16.dp, top = 40.dp)
                        .align(alignment = Alignment.Start)
                )


                EditNumberField(
                    label = "Amount",
                    value = paymentamount,
                    onValueChange = {paymentamount = it},
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done)
                )

                Spacer(modifier = Modifier.height(50.dp))


                Button(onClick = {
                    if (roundUp) {
                        if (paymentamount.toInt() == 0) {
                            nobalancetwo = "Please select an amount!!!"
                        }
                        else if (bankbalance >= paymentamount.toInt()) {
                            page = 21
                            bankbalance -= paymentamount.toInt()
                            nobalancetwo = ""
                        } else {
                            nobalancetwo = "Insufficient amount in Wallet!!!"
                        }
                    }
                    else{
                        if (paymentamount.toInt() == 0) {
                            nobalancetwo = "Please select an amount!!!"
                        }
                        else if (walletbalance >= paymentamount.toInt()) {
                            page = 21
                            walletbalance -= paymentamount.toInt()
                            nobalancetwo = ""
                        } else {
                            nobalancetwo = "Insufficient amount in Wallet!!!"
                        }
                    }

                }) {
                    Text(text = "Pay ➡️")

                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(text = nobalancetwo)

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 150.dp)
                ) {
                    Button(onClick = { page = 3 },
                        enabled = if (nobalancetwo == "Insufficient amount in Wallet!!!") {
                            true
                        }
                        else{
                            false
                        }
                    ) {
                        Text(text = "Add balance")
                    }
                }



            }
        }

        21 -> {

            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 10.dp)
                        .wrapContentSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(text =

                        if (roundUp){
                            "Paid Rs. $paymentamount from Bank ✅"
                        }
                        else {
                            "Paid Rs. $paymentamount from Wallet ✅"
                        }

                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Surface(color = Color.LightGray) {
                        Image(
                            painter = painterResource(R.drawable.paid),
                            contentDescription = null,
                            modifier = Modifier
                                .wrapContentSize()

                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(onClick = { page = 0 }) {
                        Text(text = "Done")
                    }

                }

            }
        }



        3 -> {
            Column(
                modifier = Modifier.padding(top = 150.dp, start = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Wallet Balance: Rs. $walletbalance",
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.height(150.dp))

                EditNumberField(
                    label = "Add Balance from bank: ",
                    value = addbalance,
                    onValueChange = {addbalance = it},
                    modifier = Modifier
                        .padding(bottom = 32.dp, end = 30.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done)
                )
                Button(onClick = {

                    if (addbalance.toInt() == 0) {
                        nobalancethree = "Please select an amount!!!"
                    }
                    else if(bankbalance < addbalance.toInt()){
                        nobalancethree = "Insufficient fund in bank!!!"
                    }
                    else if(bankbalance >= addbalance.toInt()){
                        walletbalance += addbalance.toInt()
                        bankbalance -= addbalance.toInt()
                        nobalancethree = ""
                    }
                    else{
                        nobalancethree = "Insufficient fund in bank!!!"
                    }
                }) {
                    Text(text = "Add to Wallet ->")
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(text = nobalancethree)

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 150.dp)
                ) {
                    Button(onClick = { page = 4 },
                        enabled = if (nobalancethree == "Insufficient fund in bank!!!") {
                            true
                        }
                        else{
                            false
                        }
                    ) {
                        Text(text = "Get Loan")
                    }
                }
            }
        }

        4 -> {
            Column(
                modifier = Modifier.padding(top = 150.dp, start = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Loan Center",
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = "loan adds money to your bank",
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.height(150.dp))

                EditNumberField(
                    label = "Get a Loan: ",
                    value = loanvalue,
                    onValueChange = {loanvalue = it},
                    modifier = Modifier
                        .padding(bottom = 32.dp, end = 30.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done)
                )
                Button(onClick = {

                    if (i > 0) {
                        if (loanvalue.toInt() == 0){
                            nobalanceone  = "Please select an amount!!!"
                        }
                        else if(10000 < loanvalue.toInt()){
                            nobalanceone = "your maximum loan value is Rs. 10000"
                        }

                        else if(10000 >= loanvalue.toInt()){
                            bankbalance += loanvalue.toInt()
                            i--
                            nobalanceone = "Loan application successful. Rs. $loanvalue has been added to the bank."
                        }
                        else {
                            nobalanceone = "your maximum loan value is Rs. 10000"
                        }
                        statement = "you can only apply loan for $i more times"
                    }

                    else{
                        statement = "You can no longer apply for loan!!!"
                        nobalanceone = "Money not added to the bank."
                    }
                }) {
                    Text(text = "Apply Loan ->")
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(text = nobalanceone, modifier = Modifier.padding(horizontal = 30.dp))
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = statement)

                Spacer(modifier = Modifier.height(30.dp))


            }
        }

        5-> {

            Column(
                modifier = Modifier.padding(top = 150.dp, start = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Rewards Center",
                    style = MaterialTheme.typography.displaySmall
                )

                Text(
                    text = "Rs. 500 will be added to the bank if both the dice show the same number",
                    modifier = Modifier.padding(10.dp)
                )

            }

            var result1 by remember { mutableStateOf(1) }
            var result2 by remember { mutableStateOf(1) }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = getDiceImageResource(result1)),
                    contentDescription = result1.toString()
                )
                Image(
                    painter = painterResource(id = getDiceImageResource(result2)),
                    contentDescription = result2.toString()
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    .padding(top = 450.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    result1 = (1..6).random()
                    result2 = (1..6).random()

                    if (result1 == result2) {
                        bankbalance += 500
                        rewardtext = "Reward recieved. Rs.500 is added to your bank"
                    } else {
                        rewardtext = ""
                    }

                })
                {
                    Text(text = "Roll")
                }
                Text(text = "$result1 , $result2")
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Text(text = rewardtext)
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Text(text = "Bank Balance: $bankbalance")

            }

        }

    }

}



@SuppressLint("SupportAnnotationUsage")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    keyboardOptions: KeyboardOptions,
    value: String,
     @StringRes label: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier

) {
    TextField(
        modifier = modifier,
        value = value,
        keyboardOptions = keyboardOptions,
        onValueChange = onValueChange,
        singleLine = true,


    )
}
@Composable
fun paymentmethod (
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

            .padding(start = 40.dp, top = 150.dp),
        horizontalAlignment = Alignment.Start

    ) {
        Text(text = "Pay directly From Bank:"
        )
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopStart),
        )

    }
}

@Composable
fun getDiceImageResource(result: Int): Int {
    return when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}
