<script setup>

	import { ref } from 'vue'
	import { useRouter } from 'vue-router';

	async function fetchData() {
		return await fetch('http://localhost:8080/api').then((r) => r.json());
	}

	const loginData = await fetchData();

	const username = defineModel('username');

	const dialog = ref(false);

	function closeDialog() {
		dialog.value = false;
		username.value = "";
	}
	
	let role;

	function validate() {
		for (let i = 0; i < loginData.length; i++) {
			if (loginData[i].name.toLowerCase() === username.value.toLowerCase()) {
				role = loginData[i].role;
				return true;
			}
		}
		return false;
	}

	const router = useRouter();
	
	function login() {

		console.log(navigate);

		if (!validate()) {
			dialog.value = true;
		} else {
			router.push({name: role});
		}
	}

	
</script>


<template>

	<v-container fluid>
		<v-card>
			<v-card-text>
				<form ref="form" @submit.prevent="login()">
					<v-text-field
					v-model="username"
					name="username"
					label="Username"
					type="text"
					required
					></v-text-field>

					<v-btn type="submit">Login</v-btn>
					
				</form>
			</v-card-text>
		</v-card>

		<v-dialog v-model="dialog" width="auto">
			<v-card
				max-width="400"
				prepend-icon="mdi-alert-circle-outline"
				text="User not found!"
				title="Login error"
			>
				<template v-slot:actions>
				<v-btn
					class="ms-auto"
					text="Close"
					@click="closeDialog()"
				></v-btn>
				</template>
			</v-card>
		</v-dialog>
	</v-container>
</template>


