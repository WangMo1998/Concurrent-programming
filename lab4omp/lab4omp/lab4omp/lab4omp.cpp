#include "pch.h"
#include <iostream>
#include <map>
#include <omp.h>
#include <cmath>
#include <chrono>


using namespace std;
using namespace std ::chrono;

class Data {
public:
	int C;
	map<pair<double, double>, double> * A;

	Data() {
		C = 1;
		A = new map<pair<double, double>, double>();
	}
};

int main()
{
	Data*  D = new Data();

	double T = 1.2; // ѕериод волн?
	double V = 15.0; // —корость волн?
	double A0 = 0.02; // јмплитуд?колебани?

	double step_t = 0.1; // Ўа?времен?
	double step_x = 1.0; // Ўа?рассто¤ни¤

	int steps_t = 1000;
	int steps_x = 1000;

	milliseconds start = duration_cast<milliseconds>(system_clock::now().time_since_epoch());

	omp_lock_t savelock;
	omp_init_lock(&savelock);

#pragma omp parallel for num_threads(16)
	while (true) {

		double cur_t;
		double cur_x;

		omp_set_lock(&savelock);
		cur_t = step_t * (D->C / steps_t + 1);
		cur_x = step_x * (D->C % steps_x);
		D->C++;
		omp_unset_lock(&savelock);

		double calc_A;

		calc_A = A0 * cos(((2 * 3.14) / T) * (cur_t - (cur_x / V)));

		omp_set_lock(&savelock);
		D->A->insert(pair<pair<double, double>, double>(pair<double, double>(cur_t, cur_x), calc_A));
		if (D->C == steps_t * steps_x) {
			break;
		}
		omp_unset_lock(&savelock);

	}

	milliseconds finish = duration_cast<milliseconds>(system_clock::now().time_since_epoch());

	cout << (finish - start).count() << endl;
	cout << D->A->at(pair<double,double>(4.0,45.0)) << endl;
	return 0;
}
